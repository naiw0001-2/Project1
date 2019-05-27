package com.mojuk.Board.Service;

import com.mojuk.Board.BoardDAO;
import com.mojuk.Board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListBoard")
public class ListBoard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BoardDAO dao = new BoardDAO();
        int page = Integer.parseInt(request.getParameter("page"));
        List<BoardVO> list = dao.getBoardList(page);

        request.setAttribute("list",list);

        response.sendRedirect("list.jsp");
    }
}
