package priv.luruidi.bean;

import java.util.Date;

public class BbsCommentReply {
    private int id;
    private String replycomment;
    private int commentid;
    private int userid;
    private Date replytime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReplycomment() {
        return replycomment;
    }

    public void setReplycomment(String replycomment) {
        this.replycomment = replycomment;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}
