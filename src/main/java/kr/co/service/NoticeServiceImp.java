package kr.co.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.domain.NoticeVO;
import kr.co.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImp implements NoticeService {
	
	private final NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeVO> getList() {
		return noticeMapper.getList();
	}

	@Override
	public void register(NoticeVO notice) {
		noticeMapper.insert(notice);
	}

	@Override
	public Long registerSelectKey(NoticeVO notice) {
		noticeMapper.insertSelectKey(notice);
		return notice.getNno();
	}

	@Override
	public NoticeVO get(Long nno) {
		return noticeMapper.read(nno);
	}

	@Override
	public int modify(NoticeVO notice) {
		return noticeMapper.update(notice);
	}

	@Override
	public int remove(Long nno) {
		return noticeMapper.delete(nno);
	}

}
