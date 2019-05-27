<%@ page import="com.mojuk.Board.BoardDAO" %>
<%@ page import="com.mojuk.Board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nb_id = request.getParameter("nb_no");
    BoardDAO dao = new BoardDAO();
    BoardVO vo = dao.getBoard(Integer.parseInt(nb_id));
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
    <title>detail</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <style>
        div#app{
            width:100%;
            margin: 0 auto;
        }

        h3{
            text-align: center;
        }
        table{
            margin: 0 auto;
        }
        td{
            width:100px;
        }

        #myBoard{
            margin:0 auto;
            display: inline-block;
            width:100%;
        }

    </style>
</head>
<body>
<div id="app">
        <h3>상세보기</h3>
        <table>
            <tr>
                <td colspan="2">
                    제목
                </td>
                <td colspan="2">
                    <%=vo.getNb_title()%>
                </td>
            </tr>
            <tr>
                <td>
                    글쓴이
                </td>
                <td>
                    <%=vo.getNb_user_id()%>
                </td>
                <td>
                    날짜
                </td>
                <td>
                    <%=vo.getNb_date()%>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    내용
                </td>
                <td colspan="2">
                    <%=vo.getNb_content()%>
                </td>
            </tr>
        </table>

    <div id="myBoard" style="display:none;">
        <input type="button" value="수정" onclick="modify();" style="width:50%;float:left">
        <form method="get" action="/DeleteBoard" id="btnForm">
            <input type="hidden" name="no" value="<%=vo.getNb_no()%>">
            <input type="submit" value="삭제" style="width:50%">
        </form>

    </div>

</div>
    <script>
        <%
            if(vo.getNb_user_id().equals(request.getSession().getAttribute("id"))){
        %>
        document.getElementById("myBoard").style.display = "inline-block";

        <%
            }
        %>

        function modify(){
            location.href = "/mainBoard/update.jsp?nb_no="+<%=vo.getNb_no()%>;
        }

    </script>
</body>
</html>