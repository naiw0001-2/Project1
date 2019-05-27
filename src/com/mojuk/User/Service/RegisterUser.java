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

@WebServlet(name = "RegisterUser")
public class RegisterUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        UserVO vo = new UserVO();
        vo.setId(request.getParameter("id"));
        vo.setPasswd(request.getParameter("pw"));
        vo.setName(request.getParameter("name"));
        vo.setNickName(request.getParameter("nick"));

        UserDAO dao = new UserDAO();
        boolean result = dao.registerUser(vo);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(result){
            out.println("<script>");
            out.println("alert('회원가입에 성공하였습니다.');");
            out.println("location.href = 'login.jsp'");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('회원가입에 실패하였습니다.');");
            out.println("location.href = 'login.jsp'");
            out.println("</script>");
        }



//        response.sendRedirect("form.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
