package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class BoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num;
	private String id;
	private String title;
	private String content;
	private String writeDay;
	private String updateDay;
	private int readCnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int num, String id, String title, String content, String writeDay, String updateDay, int readCnt,
			int repRoot, int repStep, int repIndent) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeDay = writeDay;
		this.updateDay = updateDay;
		this.readCnt = readCnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
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

	public String getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}

	public String getUpdateDay() {
		return updateDay;
	}

	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
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
		BoardDTO other = (BoardDTO) obj;
		return num == other.num;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + ", writeDay="
				+ writeDay + ", updateDay=" + updateDay + ", readCnt=" + readCnt + ", repRoot=" + repRoot + ", repStep="
				+ repStep + ", repIndent=" + repIndent + "]";
	}
	
	
	

}
