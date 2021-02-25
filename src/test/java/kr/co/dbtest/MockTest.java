package kr.co.dbtest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kr.co.gjgreen.HomeController;
import kr.co.test.ControlTest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MockTest {
	
	private MockMvc mock;
	
	@Before
	public void setup() {
//		this.mock = MockMvcBuilders.standaloneSetup(new HomeController()).build();		
		this.mock = MockMvcBuilders.standaloneSetup(new ControlTest()).build();		
	}
	
	@Test
	public void mockTest() throws Exception {
//		RequestBuilder url = MockMvcRequestBuilders.get("/");
		RequestBuilder url = MockMvcRequestBuilders.get("/test/testGetName2").param("name","jihye");
		
		log.info(mock.perform(url).andReturn().getModelAndView());
	}
}
