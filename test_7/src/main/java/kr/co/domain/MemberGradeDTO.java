package kr.co.domain;

import java.io.Serializable;

public class MemberGradeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String m_no;
	private String m_name;
	private int count;
	
	public MemberGradeDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberGradeDTO(String m_no, String m_name, int count) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.count = count;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
