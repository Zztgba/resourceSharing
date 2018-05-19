package priv.luruidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.luruidi.bean.Resource;
import priv.luruidi.dao.ResourceManagerDao;
import priv.luruidi.service.ResourceManagerService;

import java.util.List;
@Service
public class ResourceManagerServiceImpl implements ResourceManagerService {
    @Autowired
    private ResourceManagerDao resourceManagerDao;
    @Override
    public List<Resource> queryResourcesByStatuState(Resource resource) {
        return resourceManagerDao.queryResourcesByStatuState(resource);
    }

    @Override
    public int updateResourceState(Resource resource) {
        return resourceManagerDao.updateResourceState(resource);
    }
}
