<%@ page import="com.mojuk.Board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mojuk.Board.BoardDAO" %>
<%@ page import="com.mojuk.User.UserDAO" %>
<%@ page import="com.mojuk.User.UserVO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int paging = 1;

    if(request.getParameter("page") != null)
        paging = Integer.parseInt(request.getParameter("page"));

    BoardDAO dao = new BoardDAO();
    List<BoardVO> list = dao.getBoardList(paging);
    UserDAO userDAO = new UserDAO();
%>

<html>
<head>
    <%
        String id = (String) request.getSession().getAttribute("id");
        if (id == null || id == "") {
    %>
        <script>
            alert("로그인 후 이용해주세요.");
            location.href = "/login.jsp";
        </script>
    <%
        }
    %>

    <title>list</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <style>
        body {
            margin: 0 auto;
        }

        #app {
            width: 100%;
        }

        #nav {
            display: inline-block;
            background: #ddd;
            width: 100%;
            position: relative;
        }

        #nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
            float: right;
        }

        #nav ul li {
            float: left;
        }

        #nav ul li a {
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        #nav ul li a:hover {
            background: #44fd22;
        }

        span.title {
            font-size: 20px;
            font-weight: bold;
        }

        table {
            border: 1px solid #888;
            text-align: center;
            margin: 0 auto;
        }

        .no {
            width: 100px;
        }

        .board_title {
            width: 200px;
        }

        .writer {
            width: 100px;
        }

        .date {
            width: 100px;
        }
        .paging{
            margin: 0 auto;
        }

        .paging ul {
            list-style: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
        }

        .paging ul li{
            float:left;
        }

        .paging ul li a{
            display: block;
            color: #666;
            text-align: center;
            padding: 5px
        }
        .paging ul li a:hover{
            color: #f00;
        }
        tr.detailRow:hover{
            cursor: pointer;
            background: #888888;
        }


    </style>
</head>
<body>
<div id="app">
    <div id="nav">
        <span class="title">게시판</span>
        <ul>
            <li><a href="User/updateUser.jsp">회원 정보</a></li>
            <li><a href="javascript:void(0);" onclick="showMembers();">회원 목록</a></li>
        </ul>
    </div>

    <input type="button" value="글쓰기" onclick="writePage();">
    <table>
        <thead>
        <tr>
            <th class="no">번호</th>
            <th class="board_title">제목</th>
            <th class="writer">등록자</th>
            <th class="date">날짜</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr class="detailRow">
            <td class="no"><%=list.get(i).getNb_no()%>
            </td>
            <td class="board_title"><%=list.get(i).getNb_title()%>
            </td>
            <td class="writer"><%=list.get(i).getNb_us_name()%>
            </td>
            <td class="date"><%=list.get(i).getNb_date()%>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
    <div class="paging">
        <ul>
            <%
                if(list.size() != 0){
                    int allPage = list.get(0).getAll() / 10;
                    if((list.get(0).getAll() % 10) != 0) allPage++;

                    for(int i=0;i<allPage;i++){

            %>
            <li class="pageLI"><a href="javascript:void(0);" onclick="changePaging(<%=i+1%>);"><%=i+1%></a></li>
            <% }} %>
        </ul>
    </div>
</div>
<script>
    function writePage() {
        location.href = "/mainBoard/write.jsp";
    }

    function showMembers() {
        var msg = "";
        <%
            List<UserVO> userList = userDAO.getAllUsers();
            for(int i=0;i<userList.size();i++){
        %>
            msg += "<%=userList.get(i).getId()%>";
            msg += " : <%=userList.get(i).getName()%>";
            msg += "\n";
        <% } %>
        alert(msg);
    }

    function changePaging(idx){
        location.href = "/mainBoard/list.jsp?page="+idx;
    }

    $(function () {
        $(".detailRow").click(function () {
            var no = $(this).children(".no").text();
            location.href = "/mainBoard/detail.jsp?nb_no=" + no;
        })

        $(".pageLI").each(function(idx){
            console.log($(this).find('a').text());
            console.log($(this).text());
            console.log(<%=paging%>);
            if($(this).find('a').text() == <%=paging%>){
                console.log(123);
                $(this).find('a').css('color','red');
            }

        });
    })


</script>
</body>
</html>
