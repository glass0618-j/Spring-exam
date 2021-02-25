package kr.co.test;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TestDTOList {
	
	private List<TestDTO> list;
	
	public TestDTOList() {
		this.list = new ArrayList<>();
	}

}
