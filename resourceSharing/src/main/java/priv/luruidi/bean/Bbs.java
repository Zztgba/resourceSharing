package priv.luruidi.bean;

import java.util.Date;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 16:22:28
 */
public class Bbs {
    private Integer id;
    private String notesort;
    private String notename;
    private String notecontent;
    private Date notetime;
    private int userid;
    private int state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotesort() {
        return notesort;
    }

    public void setNotesort(String notesort) {
        this.notesort = notesort;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent;
    }

    public Date getNotetime() {
        return notetime;
    }

    public void setNotetime(Date notetime) {
        this.notetime = notetime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
