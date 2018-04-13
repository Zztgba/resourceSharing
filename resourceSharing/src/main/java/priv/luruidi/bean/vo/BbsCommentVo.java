package priv.luruidi.bean.vo;

import priv.luruidi.bean.BbsComment;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 14:35:45
 */
public class BbsCommentVo extends BbsComment{
    private String name; //评论人姓名
    private String image; //评论人头像

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
}
