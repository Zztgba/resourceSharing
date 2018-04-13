package priv.luruidi.bean;

import java.util.Date;

public class Collect {
	private Integer id;
	private Integer userid;
	private Integer resourceid;
	private Date collecttime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getResourceid() {
		return resourceid;
	}
	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}
	public Date getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(Date collecttime) {
		this.collecttime = collecttime;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", userid=" + userid + ", resourceid=" + resourceid + ", collecttime="
				+ collecttime + "]";
	}
	
}
