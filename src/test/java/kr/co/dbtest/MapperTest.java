package kr.co.dbtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BoardVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {
	
	@Autowired
	MybatisTestMapper mtm;
	
	@Test
	public void testMt() {
		log.info(mtm.getTime02());
	}
	
	@Test
	public void searchTest() {
		log.info("...........searchTest..........");
		
		Map<String, String> map = new HashMap<>();
		map.put("W", "제목2");
		map.put("T", "수정수정");
		map.put("C", "제목2");
		
		Map<String, Map<String, String>> criteria = new HashMap<String, Map<String,String>>();
		criteria.put("map", map);
		
		List<BoardVO> list = mtm.searchTest(criteria);
		for (BoardVO boardVO : list) {
			log.info(boardVO);
		}
	}
}
