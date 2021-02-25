package kr.co.test;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/test/*")
public class ControlTest {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic.........");
	}
	
	//옛날 방식 test/legacyGet 해야됨!
	@RequestMapping(value="/legacyGet", method= RequestMethod.GET)
	public void legacyGet() {
		log.info("legacyGet.........");
	}
	
	@RequestMapping(value="/legacyPost", method= {RequestMethod.POST,RequestMethod.GET})
	public void legacyPost() {
		log.info("legacyPost.........");
	}
	
	@GetMapping("/testGet")
	public void testGet() {
		log.info("testGet.........");
	}
	
	@PostMapping("/testPost")
	public void testPost() {
		log.info("testPost.........");
	}
	
	//testGetname?name=jihye
	@GetMapping("/testGetName")
	public void testGetName(String name) {
		log.info("testGet........."+name);
	}
	
	@GetMapping("/testGetName2")
	public String testGetName2(@ModelAttribute("name") String name) {
		log.info("testGet........."+name);
		
		return "/test/testGetNameAge2";
	}
	
	//testGetnameAge?name=jihye&age=26
	//testGetnameAge?n=jihye&a=26
	@GetMapping("/testGetNameAge")
	public void testGetName(@RequestParam("n") String name, @RequestParam("a") int age) {
		log.info("testGet........."+name+ age);
	}
	
	@GetMapping("/testGetNameAge2")
	public void testGetName2(@ModelAttribute("name") String name, @ModelAttribute("age") int age) {
		log.info("testGet........."+name+ age);
	}
	
	//testGetDTO?name=jihye&age=26
	// http://localhost:8080/test/testGetDTO2?name=jihye&age=26
	@GetMapping({"/testGetDTO","/testGetDTO2"})
	public void testGetDTO(TestDTO dto) {
		log.info("testGet........."+dto);
	}
	
	//http://localhost:8080/test/testGetArray?name=jihye&name=eunhye
	@GetMapping("/testGetArray")
	public void testGetArray(@RequestParam("name") ArrayList<String> name) {
		log.info("testGet........."+name);
	}
	
	//http://localhost:8080/test/testGetArrayDTO?list%5B0%5D.name=jihye&list%5B0%5D.age=10&list%5B1%5D.name=eunhye&list%5B1%5D.age=9
	@GetMapping("/testGetArrayDTO")
	public void testGetArrayDTO(TestDTOList dto) {
		log.info("testGet........."+dto);
	}
	
	@GetMapping("/re1")
	public String re1() {
		log.info("re1...");
		return "redirect:/test/re2";
	}
	
	@GetMapping("/re2")
	public void re2() {
		log.info("re2...");
	}
}
