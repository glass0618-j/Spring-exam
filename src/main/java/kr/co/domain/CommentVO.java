package kr.co.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentVO {
	
	private Long id, bno;
	private String writer, content;
	private Date regdate;

}
