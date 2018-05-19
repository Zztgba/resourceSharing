package priv.luruidi.dao;

import priv.luruidi.bean.AdminUser;

public interface AdminUserDao {
    Integer adminLogin(AdminUser adminUser);
}