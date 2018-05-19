package priv.luruidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.luruidi.bean.AdminUser;
import priv.luruidi.service.AdminUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/AdminLoginController")
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping("/adminLogin")
    public String adminLogin(AdminUser adminUser, HttpServletRequest request){
        int count=adminUserService.adminLogin(adminUser);
        if(count==1){
            return "manager";
        }
        request.setAttribute("mes","账号或密码不正确！");
        return "backIndex";
    }

}
