package kr.co.dw.dms.domain;

import java.io.Serializable;
import java.util.Objects;

public class DmsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int did;
	private String dname;
	
	public DmsDTO() {
		// TODO Auto-generated constructor stub
	}

	public DmsDTO(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(did);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DmsDTO other = (DmsDTO) obj;
		return did == other.did;
	}

	@Override
	public String toString() {
		return "DmsDTO [did=" + did + ", dname=" + dname + "]";
	}
	
	
	

}
