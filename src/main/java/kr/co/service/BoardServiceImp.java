package kr.co.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.domain.CommentVO;
import kr.co.domain.Criteria;
import kr.co.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService {
	
	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public Long registerSelectKey(BoardVO board) {
		 boardMapper.insertSelectKey(board);
		 return board.getBno();
	}

	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return boardMapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		return boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getListPage(cri);
	}

	@Override
	public Long getTotalCount(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public void comment_register(CommentVO comment) {
		boardMapper.comment_insert(comment);
	}

	@Override
	public List<CommentVO> comment_get_list(Long bno) {
		return boardMapper.comment_list(bno);
	}

	@Override
	public void comment_modify(CommentVO comment) {
		boardMapper.comment_update(comment);
	}

	@Override
	public void comment_remove(Long id) {
		boardMapper.comment_delete(id);
	}

}
