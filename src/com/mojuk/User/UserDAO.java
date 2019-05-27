package com.mojuk.User;

import com.mojuk.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection conn = DBConn.getInstance().getConnection();

    public boolean registerUser(UserVO vo) {
        boolean result = false;
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO TB_USER (US_USER_ID,US_USER_PW,US_USER_NAME,US_USER_NICKNAME) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPasswd());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getNickName());

            int count = pstmt.executeUpdate();

            result = (count == 1);
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public boolean loginUser(String id, String pw){
        boolean result = false;
        PreparedStatement pstmt = null;
        try{
            String sql = "SELECT * FROM TB_USER WHERE US_USER_ID = ? AND US_USER_PW = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,id);
            pstmt.setString(2,pw);

            ResultSet rs = pstmt.executeQuery();

            result = rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public List<UserVO> getAllUsers(){
        List<UserVO> users = new ArrayList<>();
        PreparedStatement pstmt = null;
        try{
            String sql = "SELECT * FROM TB_USER";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                UserVO vo = new UserVO();
                vo.setId(rs.getString("US_USER_ID"));
                vo.setName(rs.getString("US_USER_NAME"));
                users.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public UserVO getUser(String id){
        UserVO vo = new UserVO();
        PreparedStatement pstmt = null;
        try{
            String sql = "SELECT * FROM TB_USER WHERE US_USER_ID = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                vo.setId(rs.getString("US_USER_ID"));
                vo.setName(rs.getString("US_USER_NAME"));
                vo.setNickName(rs.getString("US_USER_NICKNAME"));
                vo.setPasswd(rs.getString("US_USER_PW"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

    public boolean updateUser(UserVO vo){
        boolean result = false;
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE TB_USER SET US_USER_NAME = ?, US_USER_NICKNAME = ? WHERE US_USER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getName());
            pstmt.setString(2,vo.getNickName());
            pstmt.setString(3,vo.getId());

            int count = pstmt.executeUpdate();

            result = (count == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
