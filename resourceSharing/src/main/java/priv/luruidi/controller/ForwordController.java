package priv.luruidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 卢瑞迪
 * @date 2017年11月27日 下午4:51:53
 * @version V1.0
 * @Description TODO
 */
@Controller
@RequestMapping("/ForwordController")
public class ForwordController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/upload")
	public String upload(){
		return "upload";
	}

	@RequestMapping("/bbs")
	public String bbs(){
		return "bbs";
	}
}
