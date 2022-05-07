<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
<style type="text/css">
ul {
  list-style-type: none;
  padding: 0px;
  margin: 0px;
  width: 150px;
  background: #FFEEEE;
  height: 100%;
  overflow: auto;
  position: fixed;
}

li a {
  text-decoration: none;
  padding: 10px;
  display: block;
  color: #2155CD;
  font-weight: bold;
}

li a:hover {
  background: #333;
  color: #fff;
}

li a.home {
  background : #333;
  color: #fff;
}

.cd1 {
  margin-left: 120px;
}


</style>



<ul>
  <li><a class="home" href="#">글쓰기</a></li>
  <li><a href="#" title="공지! 필독!">공지사항</a></li>
  <li><a href="/board/list.do" title="글쓰기 게시판입니다">게시판1</a></li>
  <li><a href="#">게시판2</a></li>
</ul>

