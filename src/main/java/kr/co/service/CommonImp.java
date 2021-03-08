package kr.co.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
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
			f.mkdir();
		}
		
		return folder;
	}

	@Override
	public String upload(String category, MultipartFile file, HttpSession session) {
		
		String resources = session.getServletContext().getRealPath("resources");
		String upload = resources + File.separator + "upload";
		
		String folder = this.makeFolder(category, upload);
		//"asdf_filename.txt"
		String uuid = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		
		try {
			file.transferTo(new File(folder, uuid));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return folder.substring(resources.length())+File.separator+uuid;
	}

}
