package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.MemberDTO;

public interface MemberService {
	public void insert(MemberDTO dto);
	public List<MemberDTO> list();
	public MemberDTO read(String id);
	public MemberDTO updateUI(String id);
	public void update(MemberDTO dto);
	
}
