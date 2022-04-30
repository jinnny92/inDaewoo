package kr.co.board.domain;

import java.util.ArrayList;
import java.util.List;

public class PageTO<T> { //제네릭타입 pageTO를 사용할때 제네릭TO를 저장하게끔
	//어디선가 PageTO를 호출할때
	/*
	 * public class PageTO<T, K, V>
	 * private K a; private V b;
	 */
	
	private int curPage; 
	private int perPage = 10;  //한 페이지에 글 목록 몇 개씩 보여줄거냐 미리 식으로 정함. 단독변수
	private int perLine = 10; //페이지를 몇 페이지까지 보여줄건지 페이지 수 찍기
	private int amount; //게시글의총 개 수 DB를 통해서 알 수가 있다. //sql에서 SELECT COUNT(num) FROM tbl)board
	
	
	// totalpage = amount/perPage +1; 1/10(java라 몫은 버리는 연산자)+1은 1페이지
	private int totalPage;
	private int startNum; //종속변수 위에 단독변수들에 의해 이 값이 바뀌는것
	private int endNum;//종속변수
	
	private int beginPageNum;//종속변수
	private int finishPageNum;//종속변수
	
	private List<T> list = new ArrayList<T>(); //제네릭타입 pageTO를 사용할때 제네릭TO를 저장하게끔
	
	public PageTO() {
		// TODO Auto-generated constructor stub
		calculate();
	}

	
	//얘는 사용자생성자는 만들지 않는다. 만약 만든다면 curPage하나정도 넘겨받음?
	
	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		calculate();
	}


	public int getCurPage() {
		return curPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		
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
	
	private void calculate() {
		totalPage = (amount-1)/perPage +1;
		startNum = (curPage - 1) * perPage +1;  
		endNum = curPage * perPage;
		if (endNum>amount) {
			endNum = amount;
		}
		
			beginPageNum = ((curPage-1) / perLine)*perLine + 1;
	      
			finishPageNum = beginPageNum + perLine -1;
			
	      if(finishPageNum > totalPage) {
	         finishPageNum = totalPage;
	      }
	}
	
	// curPage: 1
	// startNum: 1
	// endNum: 10
	
	// curPage: 2
	// startNum: 11
	// endNum: 20
	
	
}