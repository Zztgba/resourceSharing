package priv.luruidi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.luruidi.bean.Score;
import priv.luruidi.dao.ScoreDao;
import priv.luruidi.service.ScoreService;

/**
 * @author 卢瑞迪
 * @date 2017年12月6日 下午4:07:55
 * @version V1.0
 * @Description TODO
 */
@Service
public class ScoreServiceImpl implements ScoreService{
	@Resource
	private ScoreDao scoreDao;
	@Override
	public List<Score> queryScoreByUserid(Integer userid) {
		return scoreDao.queryScoreByUserid(userid);
	}
	@Override
	public Integer saveScoreByUserid(Score score) {
		return scoreDao.saveScoreByUserid(score);
	}

}
