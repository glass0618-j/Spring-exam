package kr.co.service;

import java.util.List;

import kr.co.domain.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> getList();
	
	public void register(NoticeVO notice);
	
	public Long registerSelectKey(NoticeVO notice);
	
	public NoticeVO get(Long nno);
	
	public int modify(NoticeVO notice);
	
	public int remove(Long nno);
}
