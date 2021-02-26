package kr.co.dbtest;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.co.domain.BoardVO;

public interface MybatisTestMapper {
	
	@Select("select sysdate from dual")
	public String getTime01();
	
	public String getTime02();
	
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);
	
}
