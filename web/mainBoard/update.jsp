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
    <title>write</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
<div id="app">
    <div class="section">
        <h3>수정하기</h3>
        <form action="/UpdateBoard" method="get">
            <table>
                <input type="hidden" name="no" value=<%=nb_id%>>
                <tr>
                    <td>
                        제목
                    </td>
                    <td>
                        <input type="text" name="title" value=<%=vo.getNb_title()%>>
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea rows="10" cols="100" name="content"><%=vo.getNb_content()%></textarea>
                    </td>
                </tr>
            </table>
            <input type="submit" value="등록">
        </form>
    </div>
</div>

</body>
</html>
