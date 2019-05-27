<%@ page import="com.mojuk.User.UserDAO" %>
<%@ page import="com.mojuk.User.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserDAO dao = new UserDAO();
    UserVO vo = dao.getUser((String)request.getSession().getAttribute("id"));
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
    <title>Update</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <style>
        #app{
            position:absolute;
            top: 50%;
            left: 50%;
            transform:translate(-50%,-50%);
        }
        h3{
            text-align: center;
        }
        input[type="text"], input[type="password"]{
            width: 300px;
            padding: 8px;
        }
        table{
            text-align: center;
        }
        input[type="submit"]{
            width: 100%;
        }
    </style>
</head>
<body>
<div id="app">
    <h3>회원정보</h3>
    <form action="/UpdateUser" method="post">
        <table>
            <tr>
                <td>
                    아이디
                </td>
                <td>
                    <input type="text" name="id" placeholder="아이디" value="<%=vo.getId()%>" readonly>
                </td>
            </tr>

            <tr>
                <td>
                    비밀번호
                </td>
                <td>
                    <input type="password" name="pw" placeholder="비밀번호" value="<%=vo.getPasswd()%>" readonly>
                </td>
            </tr>

            <tr>
                <td>
                    이름
                </td>
                <td>
                    <input type="text" name="name" placeholder="이름" value="<%=vo.getName()%>">
                </td>
            </tr>

            <tr>
                <td>
                    닉네임
                </td>
                <td>
                    <input type="text" name="nick" placeholder="닉네임" value="<%=vo.getNickName()%>">
                </td>
            </tr>
        </table>
        <input type="submit" value="수정">
    </form>

</div>

</body>
</html>
