package kr.co.dbtest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.domain.CommentVO;
import kr.co.domain.Criteria;
import kr.co.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	
	@Autowired
	BoardMapper bm;
	
	@Test
	public void getListTest() {
		log.info("getListTest................");
		List<BoardVO> vo = bm.getList();
		
		for(BoardVO boardVO : vo) {
			log.info(boardVO);
		}
	}
	
	
	@Test
	public void insertTest() {
		log.info("insertTest................");
		BoardVO vo = new BoardVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		bm.insert(vo);
		this.getListTest();
		
	}
	
	@Test
	public void insertSelectKeyTest() {
		log.info("insertSelectKey................");
		BoardVO vo = new BoardVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		bm.insertSelectKey(vo);
		log.info(vo);
		this.getListTest();
	}
	
	@Test
	public void readTest() {
		log.info("read................");
		log.info(bm.read(10L));
	}
	
	@Test
	public void updateTest() {
		log.info("update................");
		BoardVO vo = new BoardVO();
		vo.setTitle("수정제목 updateTest 10");
		vo.setContent("수정내용 updateTest 10");
		vo.setBno(10L);
		log.info(vo);
		bm.update(vo);
//		log.info(bm.update(vo));
		this.getListTest();
	}
	
	@Test
	public void deleteTest() {
		log.info("delete................");
		log.info(bm.delete(21L));
		
		this.getListTest();
	}
	
	@Test
	public void getListPageTest() {
		log.info("getListPageTest...............");
		Criteria cri = new Criteria();
		List<BoardVO> list = bm.getListPage(cri);
		for(BoardVO boardVO : list) {
			log.info(boardVO);
		}
	}
	
	@Test
	public void getTotalCount() {
		log.info("getTotalCountTest............");
		
		log.info(bm.getTotalCount(null));
	}
	
	@Test
	public void searchTest() {
		log.info("searchTest....");
		Criteria cri = new Criteria();
		cri.setType("TCW");
//		cri.setType("C");
		cri.setKeyword("test");
		
		List<BoardVO> list = bm.getListPage(cri);
		
		log.info(bm.getTotalCount(cri));
		
		for (BoardVO boardVO : list) {
			log.info(boardVO);
		}
	}
	
	@Test
	public void comment_insertTest() {
		log.info("comment_insertTest...............");
		CommentVO comment = new CommentVO();
		comment.setWriter("comment 작성자 10");
		comment.setContent("comment 내용 100");
		comment.setBno(4999L);
		bm.comment_insert(comment);
		
		this.comment_listTest();
	}
	
	@Test
	public void comment_listTest() {
		log.info("comment_listTest................");
		List<CommentVO> list = bm.comment_list(4999L);
		for (CommentVO commentVO : list) {
			log.info(commentVO);
		}
	}
	
	@Test
	public void comment_updateTest() {
		log.info("comment_updateTest................");
		CommentVO comment = new CommentVO();
		comment.setContent("comment 내용 100");
		comment.setId(1L);
		bm.comment_update(comment);
		
		this.comment_listTest();
	}
	
	@Test
	public void comment_deleteTest() {
		log.info("comment_deleteTest...........");
		bm.comment_delete(13L);
		
		this.comment_listTest();
	}
}
