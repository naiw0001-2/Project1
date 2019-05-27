package com.mojuk.Board;

import com.mojuk.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDAO {
    Connection conn = DBConn.getInstance().getConnection();

    public boolean writeBoard(BoardVO vo) {
        boolean result = false;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO TB_NOTICE_BOARD (NB_USER_ID, NB_TITLE, NB_CONTENT, NB_DATE) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,vo.getNb_user_id());
            pstmt.setString(2,vo.getNb_title());
            pstmt.setString(3,vo.getNb_content());
            pstmt.setString(4,vo.getNb_date());

            int count = pstmt.executeUpdate();

            result = (count == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<BoardVO> getBoardList(int paging){
        List<BoardVO> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        try{

            String sql = "SELECT *, (SELECT US_USER_NAME FROM TB_USER WHERE US_USER_ID = nb.NB_USER_ID) name, (SELECT count(*) FROM TB_NOTICE_BOARD) counts FROM TB_NOTICE_BOARD nb LIMIT 10 OFFSET ?";
            pstmt = conn.prepareStatement(sql);
            if(paging == 1 || paging == 0)
                paging = 0;
            else {
                paging = (paging -1 ) * 10;
            }
            pstmt.setInt(1,paging);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                BoardVO vo = new BoardVO();
                int no = rs.getInt("NB_NO");
                String id = rs.getString("NB_USER_ID");
                String title = rs.getString("NB_TITLE");
                String content = rs.getString("NB_CONTENT");
                String date = rs.getString("NB_DATE");
                String name = rs.getString("name");
                int all = rs.getInt("counts");

                vo.setNb_no(no);
                vo.setNb_user_id(id);
                vo.setNb_title(title);
                vo.setNb_content(content);
                vo.setNb_date(date);
                vo.setNb_us_name(name);
                vo.setAll(all);
                list.add(vo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BoardVO getBoard(int no){
        BoardVO vo = new BoardVO();
        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT * FROM TB_NOTICE_BOARD WHERE NB_NO = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            ResultSet rs = pstmt.executeQuery();
            rs.first();
            vo.setNb_no(rs.getInt("NB_NO"));
            vo.setNb_user_id(rs.getString("NB_USER_ID"));
            vo.setNb_title(rs.getString("NB_TITLE"));
            vo.setNb_content(rs.getString("NB_CONTENT"));
            vo.setNb_date(rs.getString("NB_DATE"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }


    public boolean updateBoard(int no,String title, String content){
        boolean result = false;
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE TB_NOTICE_BOARD SET NB_DATE = ?, NB_TITLE = ?, NB_CONTENT = ? WHERE NB_NO = ?";
            pstmt = conn.prepareStatement(sql);
            Date now = new Date();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            pstmt.setString(1,format.format(now));
            pstmt.setString(2,title);
            pstmt.setString(3,content);
            pstmt.setInt(4,no);
            int count = pstmt.executeUpdate();

            result = (count == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteBoard(int no){
        boolean result = false;
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM TB_NOTICE_BOARD WHERE NB_NO = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            int count = pstmt.executeUpdate();

            result = (count == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
