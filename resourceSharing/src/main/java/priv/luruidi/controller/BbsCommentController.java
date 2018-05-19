package priv.luruidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.luruidi.bean.BbsComment;
import priv.luruidi.service.BbsCommentService;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 16:46:20
 */
@Controller
@RequestMapping("/BbsCommentController")
public class BbsCommentController {
    @Autowired
    private BbsCommentService bbsCommentService;
    @RequestMapping("/saveBbsComment")
    public void saveBbsComment(BbsComment bbsComment, HttpServletResponse response) throws Exception{
        bbsComment.setCommenttime(new Date());
        int count= bbsCommentService.saveBbsComment(bbsComment);
        if(count==1){
            response.sendRedirect("../BbsController/bbsDetail.action?id="+bbsComment.getBbsid());
        }
    }

}
