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
	private String writerDay;
	private String updateDay;
	private int readcnt;
	private int reproot;
	private int repstep;
	private int repindent; 
	
public BoardDTO() {
	// TODO Auto-generated constructor stub
}

public BoardDTO(int num, String writer, String title, String content, String writerDay, String updateDay, int readcnt,
		int reproot, int repstep, int repindent) {
	super();
	this.num = num;
	this.writer = writer;
	this.title = title;
	this.content = content;
	this.writerDay = writerDay;
	this.updateDay = updateDay;
	this.readcnt = readcnt;
	this.reproot = reproot;
	this.repstep = repstep;
	this.repindent = repindent;
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
	return writerDay;
}

public void setWriterDay(String writerDay) {
	this.writerDay = writerDay;
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
	return reproot;
}

public void setReproot(int reproot) {
	this.reproot = reproot;
}

public int getRepstep() {
	return repstep;
}

public void setRepstep(int repstep) {
	this.repstep = repstep;
}

public int getRepindent() {
	return repindent;
}

public void setRepindent(int repindent) {
	this.repindent = repindent;
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
			+ writerDay + ", updateDay=" + updateDay + ", readcnt=" + readcnt + ", reproot=" + reproot + ", repstep="
			+ repstep + ", repindent=" + repindent + "]";
}



}
	