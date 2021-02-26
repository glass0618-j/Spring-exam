package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	public void register(BoardVO board);
	
	public Long registerSelectKey(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public int modify(BoardVO board);
	
	public int remove(Long bno);
	
	public Long getTotalCount(Criteria cri);
}