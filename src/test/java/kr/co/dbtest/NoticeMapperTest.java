package kr.co.dbtest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import kr.co.domain.NoticeVO;
import kr.co.mapper.BoardMapper;
import kr.co.mapper.NoticeMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeMapperTest {
	
	@Autowired
	NoticeMapper nm;
	
	@Test
	public void getListTest() {
		log.info("getListTest................");
		List<NoticeVO> vo = nm.getList();
		
		for(NoticeVO noticeVO : vo) {
			log.info(noticeVO);
		}
	}
	
	
	@Test
	public void insertTest() {
		log.info("insertTest................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		
		nm.insert(vo);
		this.getListTest();
		
	}
	
	@Test
	public void insertSelectKeyTest() {
		log.info("insertSelectKey................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("새글제목 insertTest 10");
		vo.setContent("새글내용 insertTest 10");
		vo.setWriter("작성자 insert 10");
		log.info(vo);
		nm.insertSelectKey(vo);
		log.info(vo);
		this.getListTest();
	}
	
	@Test
	public void readTest() {
		log.info("read................");
		log.info(nm.read(10L));
	}
	
	@Test
	public void updateTest() {
		log.info("update................");
		NoticeVO vo = new NoticeVO();
		vo.setTitle("수정제목 updateTest 10");
		vo.setContent("수정내용 updateTest 10");
		vo.setNno(10L);
		log.info(vo);
		nm.update(vo);
//		log.info(bm.update(vo));
		this.getListTest();
	}
	
	@Test
	public void deleteTest() {
		log.info("delete................");
		log.info(nm.delete(21L));
		
		this.getListTest();
	}
}
