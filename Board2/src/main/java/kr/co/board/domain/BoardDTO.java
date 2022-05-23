package kr.co.board.domain;

import java.io.Serializable;
import java.util.Objects;

public class BoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num;
	private String writer;
	private String title;
	private String writeDay;
	private String updateDay;
	private int readcnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	

public BoardDTO() {
	// TODO Auto-generated constructor stub
}


public BoardDTO(int num, String writer, String title, String writeDay, String updateDay, int readcnt, int repRoot,
		int repStep, int repIndent) {
	super();
	this.num = num;
	this.writer = writer;
	this.title = title;
	this.writeDay = writeDay;
	this.updateDay = updateDay;
	this.readcnt = readcnt;
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


public String getWriter() {
	return writer;
}


public void setWriter(String writer) {
	this.writer = writer;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
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


public int getReadcnt() {
	return readcnt;
}


public void setReadcnt(int readcnt) {
	this.readcnt = readcnt;
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
	return "BoardDTO [num=" + num + ", writer=" + writer + ", title=" + title + ", writeDay=" + writeDay
			+ ", updateDay=" + updateDay + ", readcnt=" + readcnt + ", repRoot=" + repRoot + ", repStep=" + repStep
			+ ", repIndent=" + repIndent + "]";
}




}
