package priv.luruidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.service.BbsManagerService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/BbsManager")
public class BbsManagerController {
    @Autowired
    private BbsManagerService bbsManagerService;
    @RequestMapping("/queryBbsByStatuState/{state}")
    public ModelAndView queryBbsByStatuState(@PathVariable int state){
        Bbs bbs = new Bbs();
        bbs.setState(state);
        List<BbsVo> list = bbsManagerService.queryBbsByStatuState(bbs);
        ModelAndView modelAndView = new ModelAndView();
        if(state==0){
            modelAndView.setViewName("bbsCheck");
            modelAndView.addObject("list",list);
        }
        if(state==1){
            modelAndView.setViewName("publishedbbs");
            modelAndView.addObject("list",list);
        }
        if(state==2){
            modelAndView.setViewName("backBbs");
            modelAndView.addObject("list",list);
        }
        return modelAndView;
    }
    @RequestMapping("/updateBbsState/{flag}")
    public void updateBbsState(@PathVariable int flag, Bbs bbs, int index, HttpServletResponse response) throws Exception{
        //审核
        if(flag==1){
            bbs.setState(1);
        }
        //撤销
        if(flag==2){
            bbs.setState(2);
        }
        int count = bbsManagerService.updateBbsState(bbs);
        if(index==1){
            response.sendRedirect("../queryBbsByStatuState/2.action");
        }else if(index==2){
            response.sendRedirect("../queryBbsByStatuState/1.action");
        }else{
            response.sendRedirect("../queryBbsByStatuState/0.action");
        }
    }
}
