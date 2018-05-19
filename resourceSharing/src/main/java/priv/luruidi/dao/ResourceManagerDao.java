package priv.luruidi.dao;

import priv.luruidi.bean.Resource;

import java.util.List;

public interface ResourceManagerDao {
    List<Resource> queryResourcesByStatuState(Resource resource);
    int updateResourceState(Resource resource);
}
