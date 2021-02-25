package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.NoticeVO;
import kr.co.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/notice/*")
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeService noticeService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...............");
		model.addAttribute("list", noticeService.getList());
	}
	
	@PostMapping("/register")
	public String register(NoticeVO notice, RedirectAttributes ra) {
		log.info("register...............");
		log.info("register : "+notice.getTitle()+"....................");
//		boardService.register(notice);
		long nno = noticeService.registerSelectKey(notice);
//		ra.addAttribute("result", nno);
		ra.addFlashAttribute("result", nno);
		
		return "redirect:/notice/get?nno="+nno;
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register get.................");
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("nno") Long nno, Model model) {
		log.info("get...............");
		model.addAttribute("notice", noticeService.get(nno));
	}
	
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes ra) {
		log.info("modify...............");
		
		log.info("modify"+notice.getNno());
		
		int count = noticeService.modify(notice);
		
		if(count == 1) {
			ra.addFlashAttribute("result", "success");
		}
		
		return "redirect:/notice/get?nno="+notice.getNno();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("nno") Long nno, RedirectAttributes ra) {
		log.info("remove...............");
		
		int count = noticeService.remove(nno);
		
		if(count == 1) {
			ra.addFlashAttribute("result", "success");
		}
		
		return "redirect:/notice/list";
	}
	
}

