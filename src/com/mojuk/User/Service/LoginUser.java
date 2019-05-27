package com.mojuk.User.Service;

import com.mojuk.User.UserDAO;
import com.mojuk.User.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginUser")
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        UserDAO dao = new UserDAO();
        boolean result = dao.loginUser(id,pw);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(result){
            request.getSession().setAttribute("id",id);
            out.println("<script>");
            out.println("alert('환영합니다.');");
            out.println("location.href='mainBoard/list.jsp'");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('로그인 실패');");
            out.println("location.href='/login.jsp'");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
