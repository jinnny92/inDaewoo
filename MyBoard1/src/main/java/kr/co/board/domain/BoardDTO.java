package kr.co.board.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class BoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num;
	private String writer;
	private String title;
	private String content;
	private String writeDay;
	private String updateDay;
	private int readcnt;
	private int repRoot;
	private int repStep;
	private int repIndent; 
	
public BoardDTO() {
	// TODO Auto-generated constructor stub
}

public BoardDTO(int num, String writer, String title, String content, String writeDay, String updateDay, int readcnt,
		int reproot, int repstep, int repindent) {
	super();
	this.num = num;
	this.writer = writer;
	this.title = title;
	this.content = content;
	this.writeDay = writeDay;
	this.updateDay = updateDay;
	this.readcnt = readcnt;
	this.repRoot = reproot;
	this.repStep = repstep;
	this.repIndent = repindent;
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

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getWriterDay() {
	return writeDay;
}

public void setWriterDay(String writerDay) {
	this.writeDay = writerDay;
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

public int getReproot() {
	return repRoot;
}

public void setReproot(int reproot) {
	this.repRoot = reproot;
}

public int getRepstep() {
	return repStep;
}

public void setRepstep(int repstep) {
	this.repStep = repstep;
}

public int getRepindent() {
	return repIndent;
}

public void setRepindent(int repindent) {
	this.repIndent = repindent;
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
	return "BoardDTO [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", writerDay="
			+ writeDay + ", updateDay=" + updateDay + ", readcnt=" + readcnt + ", reproot=" + repRoot + ", repstep="
			+ repStep + ", repindent=" + repIndent + "]";
}



}
	