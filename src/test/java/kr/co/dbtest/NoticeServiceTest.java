package kr.co.dbtest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.NoticeVO;
import kr.co.service.NoticeService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeServiceTest {
	
	@Autowired
	NoticeService ns;
	
	@Test
	public void getListTest() {
		log.info("getListTest................");
		List<NoticeVO> vo = ns.getList();
		
		for(NoticeVO notiveVO : vo) {
			log.info(notiveVO);
		}
	}
	
	@Test
	public void registerTest() {
		log.info("registerTest................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		ns.register(vo);
		this.getListTest();
	}
	
	@Test
	public void registerSelectKeyTest() {
		log.info("registerSelectKey................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		long nno = ns.registerSelectKey(vo);
		log.info(nno);
		this.getListTest();
	}
	
	@Test
	public void getTest() {
		log.info("get................");
		log.info(ns.get(2L));
	}
	
	@Test
	public void modifyTest() {
		log.info("modify................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("수정제목 modifyTest 10");
		vo.setContent("수정내용 modifyTest 10");
		vo.setNno(3L);
		log.info(vo);
		ns.modify(vo);
		this.getListTest();
	}
	
	@Test
	public void removeTest() {
		log.info("remove................");
		log.info(ns.remove(2L));
		
		this.getListTest();
	}
}
