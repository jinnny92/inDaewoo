package kr.co.domain;

import java.io.Serializable;

public class VoteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String v_jumin;
	private String v_name;
	private String m_no;
	private String v_time;
	private String v_area;
	private String c_confirm;
	
	public VoteDTO() {
		// TODO Auto-generated constructor stub
	}

	public VoteDTO(String v_jumin, String v_name, String m_no, String v_time, String v_area, String c_confirm) {
		super();
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_area = v_area;
		this.c_confirm = c_confirm;
	}

	public String getV_jumin() {
		return v_jumin;
	}

	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
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

	public String getV_area() {
		return v_area;
	}

	public void setV_area(String v_area) {
		this.v_area = v_area;
	}

	public String getC_confirm() {
		return c_confirm;
	}

	public void setC_confirm(String c_confirm) {
		this.c_confirm = c_confirm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
