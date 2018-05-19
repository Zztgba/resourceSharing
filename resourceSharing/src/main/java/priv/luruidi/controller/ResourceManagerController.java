package priv.luruidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import priv.luruidi.bean.Resource;
import priv.luruidi.service.ResourceManagerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ResourceManager")
public class ResourceManagerController {
    @Autowired
    private ResourceManagerService resourceManagerService;
    @RequestMapping("/queryResourcesByStatuState/{state}")
    public ModelAndView queryResourcesByStatuState(@PathVariable int state){
        Resource resource=new Resource();
        resource.setState(state);
        List<Resource> list = resourceManagerService.queryResourcesByStatuState(resource);
        ModelAndView modelAndView=new ModelAndView();
        if(state==0){
            modelAndView.setViewName("resourceCheck");
            modelAndView.addObject("list",list);
        }
        if(state==1){
            modelAndView.setViewName("publishedresources");
            modelAndView.addObject("list",list);
        }
        if(state==2){
            modelAndView.setViewName("backResources");
            modelAndView.addObject("list",list);
        }
        return modelAndView;
    }
    @RequestMapping("/updateResourceState/{flag}")
    public void updateResourceState(@PathVariable int flag, Resource resource,int index,HttpServletResponse response) throws IOException {
        //审核
        if(flag==1){
            resource.setState(1);
        }
        //撤销
        if(flag==2){
            resource.setState(2);
        }
        int count = resourceManagerService.updateResourceState(resource);
        if(index==1){
            response.sendRedirect("../queryResourcesByStatuState/2.action");
        }else if(index==2){
            response.sendRedirect("../queryResourcesByStatuState/1.action");
        }else{
            response.sendRedirect("../queryResourcesByStatuState/0.action");
        }

    }
}
