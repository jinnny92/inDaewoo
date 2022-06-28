package kr.co.dw.repository.member;

import java.util.List;

import kr.co.dw.domain.MemberDTO;

public interface MemberDAO {

	void insert(MemberDTO dto);

	List<MemberDTO> list();

	MemberDTO read(String id);

	MemberDTO updateUI(String id);

	void update(MemberDTO dto);

}
