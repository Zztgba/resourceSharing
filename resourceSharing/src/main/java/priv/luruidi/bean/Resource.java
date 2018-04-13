package priv.luruidi.bean;

import java.util.Date;

/**
 * @author 卢瑞迪
 * @date 2017年12月5日 下午3:58:32
 * @version V1.0
 * @Description TODO
 */
public class Resource {
	private int id;
	private String filepath;
	private String name;
	private String type;
	private String keywords;
	private int score;
	private String description;
	private String size;
	private int userid;
	private Date uploadtime;
	private Integer downloadTimes;
	private int state;

	public Resource() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Integer getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(Integer downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", filepath=" + filepath + ", name=" + name + ", type=" + type + ", keywords="
				+ keywords + ", score=" + score + ", description=" + description + ", size=" + size + ", userid="
				+ userid + ", uploadtime=" + uploadtime + ", downloadTimes=" + downloadTimes + ", state=" + state + "]";
	}

}
