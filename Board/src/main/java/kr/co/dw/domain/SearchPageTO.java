package kr.co.dw.domain;

import java.util.ArrayList;
import java.util.List;

public class SearchPageTO<T> extends PageTO<T>{
    //page TO를 부를때 generic type을 사용할 수 있게끔 사용한거임.
	
	private String criteria;
	private String keyword;

         
   public SearchPageTO() {
      calculate();
   }

   public SearchPageTO(int curPage) {
      setCurPage(curPage);
      calculate();
   }

public String getCriteria() {
	return criteria;
}

public String getKeyword() {
	return keyword;
}
   
   
   

}
