<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
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
        <h3>회원가입</h3>
        <form action="RegisterUser" method="post">
            <table>
                <tr>
                    <td>
                        아이디
                    </td>
                     <td>
                         <input type="text" name="id" placeholder="아이디">
                     </td>
                </tr>

                <tr>
                    <td>
                        비밀번호
                    </td>
                    <td>
                        <input type="password" name="pw" placeholder="비밀번호">
                    </td>
                </tr>

                <tr>
                    <td>
                        이름
                    </td>
                    <td>
                        <input type="text" name="name" placeholder="이름">
                    </td>
                </tr>

                <tr>
                    <td>
                        닉네임
                    </td>
                    <td>
                        <input type="text" name="nick" placeholder="닉네임">
                    </td>
                </tr>
            </table>
            <input type="submit" value="회원가입">
        </form>

    </div>
    
</body>
</html>
