package kr.co.dw.repository.reply;

import java.util.List;
import java.util.Map;

import kr.co.dw.domain.ReplyDTO;

public interface ReplyDAO {

	void insert(Map<String, Object> map);

	List<ReplyDTO> list(int bno);

	void delete(Map<String, Object> map);

	void update(Map<String, Object> map);

	void deleteByBno(int bno);



	
	
}
