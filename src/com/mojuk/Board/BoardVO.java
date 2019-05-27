package com.mojuk.Board;

public class BoardVO {
    private int nb_no;
    private String nb_user_id;
    private String nb_us_name;
    private String nb_title;
    private String nb_content;
    private String nb_date;
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public String getNb_us_name() {
        return nb_us_name;
    }

    public void setNb_us_name(String nb_us_name) {
        this.nb_us_name = nb_us_name;
    }

    public int getNb_no() {
        return nb_no;
    }

    public void setNb_no(int nb_no) {
        this.nb_no = nb_no;
    }

    public String getNb_user_id() {
        return nb_user_id;
    }

    public void setNb_user_id(String nb_user_id) {
        this.nb_user_id = nb_user_id;
    }

    public String getNb_title() {
        return nb_title;
    }

    public void setNb_title(String nb_title) {
        this.nb_title = nb_title;
    }

    public String getNb_content() {
        return nb_content;
    }

    public void setNb_content(String nb_content) {
        this.nb_content = nb_content;
    }

    public String getNb_date() {
        return nb_date;
    }

    public void setNb_date(String nb_date) {
        this.nb_date = nb_date;
    }
}
