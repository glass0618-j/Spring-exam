package kr.co.domain;
//vo는 생성자가 들어가면 안 됨

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String title, content, writer, filename, filepath;
	private Date regdate, updatedate;
}
