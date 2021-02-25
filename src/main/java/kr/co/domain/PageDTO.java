package kr.co.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage, endPage;
	private boolean prev, next;
	private Criteria cri;
	private Long total;
	
	public PageDTO(Criteria cri, Long total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)Math.ceil(cri.getPageNum() / 10.0) * 10;
		
		this.startPage = endPage - 9;
		
		int realEnd = (int)Math.ceil((double)total/cri.getAmount());
		
		this.endPage = realEnd < endPage ? realEnd : endPage;
		
		this.prev = startPage > 1;
		this.next = realEnd > endPage;
				
		
	}

}
