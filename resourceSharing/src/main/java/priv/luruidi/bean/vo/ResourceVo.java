package priv.luruidi.bean.vo;

import priv.luruidi.bean.Resource;

public class ResourceVo extends Resource {
    private String uploadname; //上传资源的会员名字

    public String getUploadname() {
        return uploadname;
    }

    public void setUploadname(String uploadname) {
        this.uploadname = uploadname;
    }
}
