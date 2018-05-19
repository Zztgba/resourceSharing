package priv.luruidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.luruidi.bean.BbsCommentReply;
import priv.luruidi.service.BbsCommentReplyService;

import java.util.Date;

@Controller
@RequestMapping("/bbsComentReply")
public class BbsComentReplyController {
    @Autowired
    private BbsCommentReplyService bbsCommentReplyService;
    @RequestMapping("/saveBbsCommentReply")
    public @ResponseBody boolean saveBbsCommentReply(BbsCommentReply bbsCommentReply){
        bbsCommentReply.setReplytime(new Date());
        int count = bbsCommentReplyService.saveBbsCommentReply(bbsCommentReply);
        if(count==1){
            return true;
        }
        return false;
    }
}
