package kr.co.dw.service.reply;

import java.util.List;
import java.util.Map;

import kr.co.dw.domain.ReplyDTO;

public interface ReplyService {

	void insert(Map<String, Object> map);

	List<ReplyDTO> list(int bno);

	void delete(Map<String, Object> map);

	void update(Map<String, Object> map);

	void deleteByBno(int bno);




}
