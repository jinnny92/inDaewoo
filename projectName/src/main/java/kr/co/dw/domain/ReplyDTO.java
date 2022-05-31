package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class ReplyDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int rno;
	private String id;
	private String  replyer;
	private String  replyText;
	private String  regDay;
	private String  updateDay;

	public ReplyDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyDTO(int rno, String id, String replyer, String replyText, String regDay, String updateDay) {
		super();
		this.rno = rno;
		this.id = id;
		this.replyer = replyer;
		this.replyText = replyText;
		this.regDay = regDay;
		this.updateDay = updateDay;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getRegDay() {
		return regDay;
	}

	public void setRegDay(String regDay) {
		this.regDay = regDay;
	}

	public String getUpdateDay() {
		return updateDay;
	}

	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyDTO other = (ReplyDTO) obj;
		return rno == other.rno;
	}

	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", id=" + id + ", replyer=" + replyer + ", replyText=" + replyText + ", regDay="
				+ regDay + ", updateDay=" + updateDay + "]";
	}
	
	

}
