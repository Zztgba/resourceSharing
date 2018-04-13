package priv.luruidi.bean;

import java.util.Date;

/**
 * @author 卢瑞迪
 * @date 2017年12月6日 下午3:49:55
 * @version V1.0
 * @Description TODO
 */
public class Score {
	private int id;
	private int userid;
	private int score;
	private Date scoredate;
	private String scoresource;
	
	public Score() {
		
	}
	
	public Score(int id, int userid, int score, Date scoredate, String scoresource) {
		this.id = id;
		this.userid = userid;
		this.score = score;
		this.scoredate = scoredate;
		this.scoresource = scoresource;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getScoredate() {
		return scoredate;
	}
	public void setScoredate(Date scoredate) {
		this.scoredate = scoredate;
	}
	public String getScoresource() {
		return scoresource;
	}
	public void setScoresource(String scoresource) {
		this.scoresource = scoresource;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", userid=" + userid + ", score=" + score + ", scoredate=" + scoredate
				+ ", scoresource=" + scoresource + "]";
	}
	
}
