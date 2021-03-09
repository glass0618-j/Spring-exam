package kr.co.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonImp implements Common {
	
	// ../resources/upload/board/2021/03/08/asdf.gif 폴더를 만든다.
	
	private String makeFolder(String category, String upload) {
		
		StringBuilder sb = new StringBuilder(upload);
		sb.append(File.separator + category);
		
		Date now = new Date();
		sb.append(File.separator + new SimpleDateFormat("yyyy").format(now));
		sb.append(File.separator + new SimpleDateFormat("MM").format(now));
		sb.append(File.separator + new SimpleDateFormat("dd").format(now));
		
		String folder = sb.toString();
		
		File f = new File(folder);
		
		if(f.exists()) {
			System.out.println(f.toString());
			f.mkdirs();
		}
		
		return folder;
	}

	@Override
	public String upload(String category, MultipartFile file, HttpSession session) {
		
//		String resources = session.getServletContext().getRealPath("resources");
		String resources = "D:\\Kangjh\\eclipseExam\\Gjgreen\\src\\main\\webapp\\resources";
		String upload = resources + File.separator + "upload";
		
		String folder = this.makeFolder(category, upload);
		//"asdf_filename.txt"
		String uuid = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		
		try {
			file.transferTo(new File(folder, uuid));
		} catch (Exception e) {
			e.getMessage();
		}
		
		System.out.println(folder.toString());
		return folder.substring(resources.length())+File.separator+uuid;
	}

	@Override
	public File download(String filepath, String filename, HttpSession session, HttpServletResponse response) {
//		File file = new File(session.getServletContext().getRealPath("resources") + filepath);
		File file = new File("D:\\Kangjh\\eclipseExam\\Gjgreen\\src\\main\\webapp\\resources" + filepath);
		String mime = session.getServletContext().getMimeType(filename);
		if(mime == null) {
			mime = "application/octet-stream";
		}
		response.setContentType(mime);
		try {
			
			filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
			response.setHeader("content-disposition", "attachment; filename="+filename);
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

}
