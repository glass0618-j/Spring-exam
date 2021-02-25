package kr.co.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DbTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void jdbcTest() throws Exception {
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "gjgreen";
		String pw = "gjgreen";
		
		Class cla = Class.forName("oracle.jdbc.driver.OracleDriver");
		log.info(cla);
		
		con = DriverManager.getConnection(url, id, pw);
		
		log.info(con);
		
		String sql = "select sysdate from dual";
		psm = con.prepareStatement(sql);
		rs = psm.executeQuery();
		
		while(rs.next()) {
			log.info(rs.getDate("sysdate"));
		}
		
	}
	
	@Test
	public void hikariTest() throws Exception {
		Connection con = ds.getConnection();
		
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "gjgreen";
//		String pw = "gjgreen";
//		
//		long start = System.currentTimeMillis();
//		for(int i=0; i<=10; i++) {
//			con = ds.getConnection();
//			con = DriverManager.getConnection(url, id, pw);
//			log.info(con);
//		}
//		long end = System.currentTimeMillis();
//		
//		log.info(end-start);
		log.info(con);
		String sql = "select sysdate from dual";
		PreparedStatement psm = con.prepareStatement(sql);
		ResultSet rs = psm.executeQuery();
		
		while(rs.next()) {
			log.info(rs.getDate("sysdate"));
		}
	}
	
	@Autowired
	SqlSessionFactory ssf;
	
	@Test
	public void mybatisTest() throws Exception {
		SqlSession ss = ssf.openSession();
		Connection con = ss.getConnection();
		
		log.info(con);
	}
	
}
