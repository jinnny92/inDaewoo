package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String birth;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String id, String pw, String name, String birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}
	
	
	
	

}
