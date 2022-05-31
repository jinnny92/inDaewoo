package kr.co.dw.service.reply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.ReplyDTO;
import kr.co.dw.repository.reply.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDAO rDao;

	@Override
	public void insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		rDao.insert(map);
		
	}

	@Override
	public List<ReplyDTO> list(String id) {
		// TODO Auto-generated method stub
		return rDao.list(id);
	}

	@Override
	public void delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		rDao.delete(map);
		
	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		rDao.update(map);
		
	}
	
	
}
