package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.MemberDTO;
import kr.co.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Override
	public void delete(MemberDTO dto) {
		// TODO Auto-generated method stub
		mDao.delete(dto);
		
	}
	
	@Override
		public void update(MemberDTO dto) {
			// TODO Auto-generated method stub
				mDao.update(dto);
		}

@Override
	public MemberDTO updateUI(String id) {
		// TODO Auto-generated method stub
	
	
		MemberDTO dto = mDao.updateUI(id);
		String birth =  dto.getBirth().substring(0, 10);
		dto.setBirth(birth);
	
		return dto;
	}
	
	
	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return mDao.read(id);
	}
	
	@Autowired
	private MemberDAO mDao;
	
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}
	
	@Override
	public void insert(MemberDTO dto) {
		mDao.insert(dto);
		
	}
}
