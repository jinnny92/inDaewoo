package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDao;
	
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
		
		return  dto;
		
	}
	
	
	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return mDao.read(id);
	}	
	
	
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}
	
	@Override
	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
	
		mDao.insert(dto);
	}
	
	
	
}