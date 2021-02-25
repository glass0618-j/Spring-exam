package kr.co.dbtest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.PageDTO;
import kr.co.service.BoardService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {
	
	@Autowired
	BoardService bs;
	
	@Test
	public void getListTest() {
		log.info("getListTest................");
		List<BoardVO> vo = bs.getList();
		
		for(BoardVO boardVO : vo) {
			log.info(boardVO);
		}
	}
	
	@Test
	public void registerTest() {
		log.info("registerTest................");
		BoardVO vo = new BoardVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		bs.register(vo);
		this.getListTest();
	}
	
	@Test
	public void registerSelectKeyTest() {
		log.info("registerSelectKey................");
		BoardVO vo = new BoardVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		long bno = bs.registerSelectKey(vo);
		log.info(bno);
		this.getListTest();
	}
	
	@Test
	public void getTest() {
		log.info("get................");
		log.info(bs.get(10L));
	}
	
	@Test
	public void modifyTest() {
		log.info("modify................");
		BoardVO vo = new BoardVO();
		vo.setTitle("수정제목 modifyTest 10");
		vo.setContent("수정내용 modifyTest 10");
		vo.setBno(10L);
		log.info(vo);
		bs.modify(vo);
		this.getListTest();
	}
	
	@Test
	public void removeTest() {
		log.info("remove................");
		log.info(bs.remove(2L));
		
		this.getListTest();
	}
	
	@Test
	public void getListTest2() {
		log.info("getListPageTest2...............");
		Criteria cri = new Criteria(2,15);
		List<BoardVO> list = bs.getList(cri);
		for(BoardVO boardVO : list) {
			log.info(boardVO);
		}
	}
	
	@Test
	public void pageDTOTest() {
		log.info("pageDTOTest.......................");
		
		Criteria cri = new Criteria(22,10);
		PageDTO page = new PageDTO(cri, 250L);
		
		log.info(page);
	}
	
	@Test
	public void getTotalCount() {
		log.info("getTotalCountTest............");
		
		log.info(bs.getTotalCount(null));
	}
}
