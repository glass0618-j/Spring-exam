package kr.co.service;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface Common {
	
	String upload(String category, MultipartFile file, HttpSession session);
	
	File download(String filepath, String filename, HttpSession session, HttpServletResponse response);
}
