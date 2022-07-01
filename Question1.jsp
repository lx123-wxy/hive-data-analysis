<%@ page import="controll.BookServlet" %><%--
  Created by IntelliJ IDEA.
  User: lxwudi666
  Date: 2022/5/26
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question1</title>
    <link rel="stylesheet" type="text/css" href="CSS/source.css"/>
    <script type="text/javascript" src="jquery/echarts.min.js"></script>
    <script type="text/javascript" src="jquery/jquery-3.5.1.js" ></script>
</head>
<body>
<div class="text" id="text">
    <h1 class="h1" id="h1">
        problem statement:
        <br><br>
        1. Find the total number of books in each yearofpublication from 1990 to 1999 :
        <br><br>
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
<div id="test" style="top: 1500px; left: 400px; height: 500px; width: 900px">
    <script type="text/javascript" >
        const dom = document.getElementById("test");
        const charts = echarts.init(dom);
        const yearofpublication = [];
        const count = [];
        charts.setOption({
            title: { text: "yearofpublication"},
            legend: {data : "count"},
            xAxis: {
                type: "category",
                data :[]
            },
            yAxis: {},
            series: [
                {
                    name : "count",
                    data : [],
                    type:"line",
                }
            ]
        });
        charts.showLoading();
        $.ajax({
            type: "get",
            async : false,
            url: "Question1Servlet",
            data:{},
            dataType: "json",
            success: function (result){
                if(result){
                    for(var i = 0; i < result.length; i++){
                        yearofpublication.push(result[i].yearofpublication);
                        count.push(result[i].count);
                    }
                    charts.hideLoading();
                    charts.setOption({
                        xAxis: {
                            data: yearofpublication
                        },
                        series: [{
                            data: count
                        }]
                    });
                    }
                },
            error: function (errorMsg){
                alert("no data");
                charts.hideLoading();
                }
            })

    </script>
</div>
</body>
</html>
