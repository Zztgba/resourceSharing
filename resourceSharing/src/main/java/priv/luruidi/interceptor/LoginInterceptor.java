package priv.luruidi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import priv.luruidi.controller.ForwordController;
import priv.luruidi.service.ResourceService;
import priv.luruidi.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author luruidi
 * @description
 * @time 2018/03/25 10:15:26
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Autowired
    private ResourceService resourceService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if(request.getSession().getAttribute("user")!=null){
            return true;
        }
        //未登陆的情况，弹出登录框！
        request.setAttribute("flag","success");
        Integer totalCount= resourceService.queryResourceCount();
        //创建分页对象
        Page page=new Page(totalCount,1,5);
        List<Map<String, Object>> resourceList = resourceService.queryResource(page);
        request.setAttribute("resourceList", resourceList);
        request.setAttribute("page", page);
        request.getRequestDispatcher("../ForwordController/index.action").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
