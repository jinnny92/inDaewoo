package kr.co.domain;

import java.io.Serializable;

import oracle.net.aso.i;

public class VoteConfirmDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String v_name;
	private String v_jumin;
	private String birth;
	private String age;
	private String sex;
	private String m_no;
	private String v_time;
	private String c_confirm;
	private String confirm;
	
	public VoteConfirmDTO() {
		// TODO Auto-generated constructor stub
	}

	public VoteConfirmDTO(String v_name, String v_jumin, String age, String m_no, String v_time, String c_confirm) {
		super();
		this.v_name = v_name;
		this.v_jumin = v_jumin;
		
		this.m_no = m_no;
		
		this.c_confirm = c_confirm;
		
		String year = "19"+v_jumin.substring(0, 2);
		String month = v_jumin.substring(2, 4);
		String date = v_jumin.substring(4, 6);
		
		birth = year + "년" + month + "월" + date + "일생";
		
		this.age = "만 " + age + "세";
		
		this.v_time = v_time.substring(0, 2) + ":"+v_time.substring(2);
		
		String gender = v_jumin.substring(6, 7);
		if (gender.equals("1")) {
			sex = "남";
		}else if (gender.equals("2")) {
			sex = "여";
		}
		
		if (c_confirm.equalsIgnoreCase("Y")) {
			confirm = "확인";
		} else if (c_confirm.equalsIgnoreCase("N")){
			confirm = "미확인";
		}
		
		
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getV_jumin() {
		return v_jumin;
	}

	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getV_time() {
		return v_time;
	}

	public void setV_time(String v_time) {
		this.v_time = v_time;
	}

	public String getC_confirm() {
		return c_confirm;
	}

	public void setC_confirm(String c_confirm) {
		this.c_confirm = c_confirm;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
