package kr.co.mapper;

import java.util.List;

import kr.co.domain.NoticeVO;

public interface NoticeMapper {
	
	public List<NoticeVO> getList();
	
	public void insert(NoticeVO notice);
	
	public void insertSelectKey(NoticeVO notice);
	
	public NoticeVO read(Long nno);
	
	public int update(NoticeVO notice);
	
	public int delete(Long nno);
	

}
