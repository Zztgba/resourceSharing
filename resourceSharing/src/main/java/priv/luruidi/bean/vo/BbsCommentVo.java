package priv.luruidi.bean.vo;

import priv.luruidi.bean.BbsComment;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 14:35:45
 */
public class BbsCommentVo extends BbsComment{
    private String name; //评论人姓名
    private String image; //评论人头像
    private List<BbsCommentReplyVo> list; //回复列表
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BbsCommentReplyVo> getList() {
        return list;
    }

    public void setList(List<BbsCommentReplyVo> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
