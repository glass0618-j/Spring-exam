package kr.co.roottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class fantasy {
	
	@Autowired
	Swordman swordman;
	
	@Test
	public void fantasytTest() {
		log.info("-----------");
		log.info(swordman);
		System.out.println(swordman);
	}
}
