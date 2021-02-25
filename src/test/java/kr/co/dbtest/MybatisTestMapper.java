package kr.co.dbtest;

import org.apache.ibatis.annotations.Select;

public interface MybatisTestMapper {
	
	@Select("select sysdate from dual")
	public String getTime01();
	
	public String getTime02();
	
}
