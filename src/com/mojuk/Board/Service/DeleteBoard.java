package com.mojuk.Board.Service;

import com.mojuk.Board.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteBoard")
public class DeleteBoard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int no = Integer.parseInt(request.getParameter("no"));

        BoardDAO dao = new BoardDAO();

        boolean result = dao.deleteBoard(no);

        if(result){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('삭제 완료되었습니다.');");
            out.println("location.href='/mainBoard/list.jsp'");
            out.println("</script>");
        }
    }
}
