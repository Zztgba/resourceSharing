package priv.luruidi.service.impl;

import org.springframework.stereotype.Service;
import priv.luruidi.bean.AdminUser;
import priv.luruidi.dao.AdminUserDao;
import priv.luruidi.service.AdminUserService;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;
    @Override
    public int adminLogin(AdminUser adminUser) {
        return adminUserDao.adminLogin(adminUser);
    }
}
