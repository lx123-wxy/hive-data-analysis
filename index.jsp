<%--
  Created by IntelliJ IDEA.
  User: lxwudi666
  Date: 2022/5/19
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>book</title>
    <link rel="stylesheet" type="text/css" href="CSS/source.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
  </head>
  <br>
  <body>
    <div class="text" id="text">
      <h1 class="h1" id="h1">
        problem statement:
        <br><br>
        1. Find the total number of books in each yearofpublication from 1990 to 1999 :
        <br><br>
        2. Find top 10 books based on rating :
        <br><br>
        3. Print the top 10 userid & rating based on rating :
        <br><br>
        4. Print the number of books written by each author in the year 2000 to 2009 :
        <br><br>
        5. print the no of books published by each publisher that have ratings greater than 5 :
        <br><br>
        6. find title & authors names betwen the yearofopublication from 1995 to 2004 where rating is greater than 4. And no of letters in title <20 & no of letters in author is > 20 :
      </h1>
    </div>
    <div class="task" id="task">
      <ul>
        <li class="m1">
          <a href="Question1.jsp" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50" alt=""/>
          </a>
        </li>
        <li class="m2">
          <a href="BookServlet?value=s2" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50" alt=""/>
          </a>
        </li>
        <li class="m3">
          <a href="BookServlet?value=s3" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50" alt=""/>
          </a>
        </li>
        <li class="m4">
          <a href="BookServlet?value=s4" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50"  alt=""/>
          </a>
        </li>
        <li class="m5">
          <a href="BookServlet?value=s5" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50"  alt=""/>
          </a>
        </li>
        <li class="m6">
          <a href="BookServlet?value=s6" >
            <img src="${pageContext.request.contextPath}/image/img11.jpg" width="50" alt=""/>
          </a>
        </li>
      </ul>
    </div>
  </body>
</html>
