package priv.luruidi.service;

import java.util.List;

import priv.luruidi.bean.Score;

/**
 * @author 卢瑞迪
 * @date 2017年12月6日 下午4:07:07
 * @version V1.0
 * @Description TODO
 */
public interface ScoreService {
	public List<Score> queryScoreByUserid(Integer userid);
	public Integer saveScoreByUserid(Score score);
}
