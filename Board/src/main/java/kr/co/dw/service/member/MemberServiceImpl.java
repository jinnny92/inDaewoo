package kr.co.dw.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.repository.member.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;
	
	
	
	@Override
	public MemberDTO login(MemberDTO mDto) {
		// TODO Auto-generated method stub
		
		return	mDao.login(mDto);
		
	}

}
