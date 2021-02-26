package kr.co.domain;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum, amount;
	
	private String type, keyword;

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public Criteria() {
		this(1, 10);
	}
	
	public String[] getType() {
		return type == null ? new String[] {}:type.split("");
	}
}
