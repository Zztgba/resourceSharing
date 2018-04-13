package priv.luruidi.dao;

import java.util.List;

import priv.luruidi.bean.Score;

/**
 * @author 卢瑞迪
 * @date 2017年12月6日 下午3:54:36
 * @version V1.0
 * @Description TODO
 */
public interface ScoreDao {
	public List<Score> queryScoreByUserid(Integer userid);
	public Integer saveScoreByUserid(Score score);
}
