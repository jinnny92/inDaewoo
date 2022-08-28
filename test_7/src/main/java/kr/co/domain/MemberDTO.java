package kr.co.domain;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String m_no;
	private String m_name;
	private String p_code;
	private String p_name;
	private String p_school;
	private String schoolName;
	private String m_jumin;
	private String jumin;
	private String m_city;
	private String p_tel1;
	private String p_tel2;
	private String p_tel3;
	private String tel;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String m_no, String m_name, String p_code, String p_name, String p_school, String m_jumin,
			String m_city, String p_tel1, String p_tel2, String p_tel3) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_school = p_school;
		this.m_jumin = m_jumin;
		this.m_city = m_city;
		this.p_tel1 = p_tel1;
		this.p_tel2 = p_tel2;
		this.p_tel3	 = p_tel3;
		
		tel = p_tel1 + "-" + p_tel2 + "-" + p_tel3;
		
		jumin = m_jumin.substring(1, 7) + "-" + m_jumin.substring(7);
		
		if (p_school.equalsIgnoreCase("1")) {
			schoolName = "고졸";
		}else if (p_school.equalsIgnoreCase("2")) {
			schoolName = "학사";
		}else if (p_school.equalsIgnoreCase("3")) {
			schoolName = "석사";
		}else if (p_school.equalsIgnoreCase("4")) {
			schoolName = "박사";
		}
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

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_school() {
		return p_school;
	}

	public void setP_school(String p_school) {
		this.p_school = p_school;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getM_jumin() {
		return m_jumin;
	}

	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public String getP_tel1() {
		return p_tel1;
	}

	public void setP_tel1(String p_tel1) {
		this.p_tel1 = p_tel1;
	}

	public String getP_tel2() {
		return p_tel2;
	}

	public void setP_tel2(String p_tel2) {
		this.p_tel2 = p_tel2;
	}

	public String getP_tel3() {
		return p_tel3;
	}

	public void setP_tel3(String p_tel3) {
		this.p_tel3 = p_tel3;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
