package com.mojuk.Board.Service;

import com.mojuk.Board.BoardDAO;
import com.mojuk.Board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "WriteBoard")
public class WriteBoard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = (String) request.getSession().getAttribute("id");

        Date now = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        BoardVO vo = new BoardVO();
        vo.setNb_user_id(id);
        vo.setNb_title(request.getParameter("title"));
        vo.setNb_content(request.getParameter("content"));
        vo.setNb_date(format.format(now));

        BoardDAO dao = new BoardDAO();

        dao.writeBoard(vo);
        response.sendRedirect("/mainBoard/list.jsp");
    }
}
