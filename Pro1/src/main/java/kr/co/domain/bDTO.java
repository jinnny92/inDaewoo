package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class bDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int num;
	private String id; 
	private String title;
	private String content;
	
	public bDTO() {
		// TODO Auto-generated constructor stub
	}

	public bDTO(int num, String id, String title, String content) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		bDTO other = (bDTO) obj;
		return num == other.num;
	}

	@Override
	public String toString() {
		return "bDTO [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	

}
