package kr.co.domain;

import java.util.ArrayList;
import java.util.List;

public class PageTO<T> { //페이지TO를 사용할떄 제네릭타입을 지정하게끔
	private int curPage; //현재페이지
	private int perPage = 20; //한페이지에 보여줄 글의 개 수
	private int perLine = 10; // 1부터 몇 페이지만 보여줄건지
	private int amount; //게시글의 총 개수
	//이 네개가 가장 중요함 네개는 독립변수
	
	//위 네개에 의해서 밑에 여섯가지의 값이 바뀌기 때문에 위가 바뀌었을때마다 밑이 바뀌게끔 코드를 짜줘야함
	
	//위에 네개와 디폴트 생성자, 사용자생성자에서 똑같은 내용이 바뀌게끔 해줘야 하기 때문에 간단하게 메소드를 하나 만든다
	
	//밑에 여섯개는 종속변수 위에 독립변수에 의해 종속변수 값이 바뀐다
	private int totalPage;
	private int startNum; //페이지에 보여주는 글 시작번호
	private int endNum; //페이지에 보여주는 글 끝번호
	private int beginPageNum;
	private int finishPageNum;
	private List<T> list = new ArrayList<T>();
	
	
	
	
	public PageTO() {
		// TODO Auto-generated constructor stub
		calculate();
	}

	public PageTO(int curPage) {
		this.curPage = curPage; //현재페이지가 바뀔수 있기때문에 현재페이지에 대한 사용자 생성자만 하나 만들고 나머지는 고정이라 안만듦
		calculate();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		calculate();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		calculate();
	}

	public int getPerLine() {
		return perLine;
	}

	public void setPerLine(int perLine) {
		this.perLine = perLine;
		calculate();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		calculate();
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getFinishPageNum() {
		return finishPageNum;
	}

	public void setFinishPageNum(int finishPageNum) {
		this.finishPageNum = finishPageNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	private void calculate() {//set cur, setperPage, setperline, setamount 디폴트, 사용자에 들어갈거임
		totalPage = (amount - 1)/perPage + 1; 
//		if (amount % perPage == 0) {
//			totalPage = amount/perPage;
//		}
		
		startNum = (curPage -1) * perPage +1;
		
		
		endNum = curPage * perPage;
		if (endNum > amount) {
			endNum = amount;
		}
		
		beginPageNum = ((curPage -1) /perLine) * perLine +1;
		
		
		
		finishPageNum = beginPageNum + perLine - 1;

		if (finishPageNum > totalPage) {
			finishPageNum = totalPage;
		}
	
	
		
	}
	
} 
