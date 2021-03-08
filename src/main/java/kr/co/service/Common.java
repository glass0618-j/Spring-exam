package kr.co.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface Common {
	
	String upload(String category, MultipartFile file, HttpSession session);
}
