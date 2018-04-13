package priv.luruidi.bean.vo;

import priv.luruidi.bean.Bbs;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 19:54:40
 */
public class BbsVo extends Bbs{
    private String name;   //发帖的人的名字

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
