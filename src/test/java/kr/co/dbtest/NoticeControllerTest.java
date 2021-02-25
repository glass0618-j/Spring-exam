package kr.co.dbtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class NoticeControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mock;
	
	@Before
	public void setup() {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void listTest() throws Exception {
		log.info("listTest.............");
		
		RequestBuilder url = MockMvcRequestBuilders.get("/notice/list");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
	
	@Test
	public void registerTest() throws Exception {
		log.info("registerTest.............");
		
		RequestBuilder url = MockMvcRequestBuilders.post("/notice/reqister")
				.param("title", "control 작성 100")
				.param("content", "control 내용 100")
				.param("writer", "control 작성 100");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
	
	@Test
	public void getTest() throws Exception {
		log.info("getTest.............");
		
		RequestBuilder url = MockMvcRequestBuilders.get("/notice/get").param("nno", "1");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
	
	@Test
	public void modifyTest() throws Exception {
		log.info("modifyTest...............");
		
		RequestBuilder url = MockMvcRequestBuilders.post("/notice/modify")
				.param("title", "Control 작성 200")
				.param("content", "Control 내용 200")
				.param("nno", "9");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
	
	@Test
	public void removeTest() throws Exception {
		log.info("removeTest...............");
		
		RequestBuilder url = MockMvcRequestBuilders.post("/notice/remove")
				.param("nno", "43");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
}
