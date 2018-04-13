package priv.luruidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.User;
import priv.luruidi.bean.vo.BbsCommentVo;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.service.BbsCommentService;
import priv.luruidi.service.BbsService;
import priv.luruidi.util.Page;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 16:20:20
 */
@Controller
@RequestMapping("/BbsController")
public class BbsController {
    @Autowired
    private BbsService bbsService;
    @Autowired
    private BbsCommentService bbsCommentService;
    @RequestMapping("/saveBbs")
    @ResponseBody
    public void saveBbs(Bbs bbs, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        bbs.setNotetime(new Date());
        bbs.setUserid(user.getId());
        int count= bbsService.saveBbs(bbs);
        if(count==1){
            response.sendRedirect("../BbsController/queryBbsList.action");
        }
    }

    @RequestMapping("/queryBbsList")
    public ModelAndView queryBbsList(Integer currentPage){
        if(currentPage==null){
            currentPage=1;
        }
        ModelAndView modelAndView=new ModelAndView();
        Integer count= bbsService.queryBbsListCount();
        Page page =new Page(count,currentPage,3);
        List<BbsVo> list=bbsService.queryBbsList(page);
        modelAndView.addObject("list", list);
        modelAndView.addObject("page", page);
        modelAndView.setViewName("bbs");
        return modelAndView;
    }
    @RequestMapping("/bbsDetail")
    public ModelAndView bbsDetail(Integer id,Integer currentPage){
        ModelAndView modelAndView = new ModelAndView();
        //帖子详情
        Bbs bbs= bbsService.bbsDetail(id);
        //分页查询评论列表
        if(currentPage==null){
            currentPage=1;
        }
        Integer count=bbsCommentService.countBbsCommentList(id);
        Page page=new Page(count,currentPage,2);
        List<BbsCommentVo> list=bbsCommentService.queryBbsCommentList(id,page);
        modelAndView.addObject("list",list);
        modelAndView.addObject("page", page);
        modelAndView.addObject("bbs",bbs);
        modelAndView.setViewName("bbsdetail");
        return modelAndView;
    }
}
