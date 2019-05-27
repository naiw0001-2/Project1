<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <style>
        body{
            width: 1080px;
            margin: 0 auto;
        }
        h3{
            text-align:center;
        }
        table{
            /*border: 1px solid #000;*/
            margin: 0 auto;
            text-align:center;
        }

        form{
            margin: 0 auto;
        }

        input{
            width: 100%;
        }
        input[type="text"], input[type="password"]{
            padding: 8px;
            border: 1px solid #888;
            width: 300px;
        }
        #app{
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);
        }


    </style>
</head>
<body>
<div id="app">
    <h3>로그인</h3>
    <form action="LoginUser" method="post">
        <table>
            <tr>
                <td>
                    ID :
                </td>
                <td>
                    <input type="text" name="id" placeholder="ID" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    PW :
                </td>
                <td>
                    <input type="password" name="pw" placeholder="PASSWORD" size="20">
                </td>
            </tr>
        </table>

        <input type="submit" value="Login"/>
        <input type="button" value="Sign Up" onclick="signup();"/>
    </form>
</div>
<script>
    function signup(){
        location.href = "/form.jsp";
    }
</script>
</body>
</html>
