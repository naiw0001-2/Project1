package com.mojuk.User.Service;

import com.mojuk.Board.BoardDAO;
import com.mojuk.User.UserDAO;
import com.mojuk.User.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUser")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        UserDAO dao = new UserDAO();

        UserVO vo = new UserVO();

        vo.setId(request.getParameter("id"));
        vo.setPasswd(request.getParameter("pw"));
        vo.setName(request.getParameter("name"));
        vo.setNickName(request.getParameter("nick"));

        System.out.println(vo.getId());
        System.out.println(vo.getPasswd());
        System.out.println(vo.getName());
        System.out.println(vo.getNickName());

        boolean result = dao.updateUser(vo);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(result){
            out.println("<script>");
            out.println("alert('수정하였습니다.');");
            out.println("location.href = 'login.jsp'");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('수정 실패.');");
            out.println("location.href = 'login.jsp'");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
