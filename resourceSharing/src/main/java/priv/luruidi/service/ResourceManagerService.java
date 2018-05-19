package priv.luruidi.service;

import priv.luruidi.bean.Resource;

import java.util.List;

public interface ResourceManagerService {
    List<Resource> queryResourcesByStatuState(Resource resource);
    int updateResourceState(Resource resource);
}


