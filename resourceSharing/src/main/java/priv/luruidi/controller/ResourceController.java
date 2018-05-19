package priv.luruidi.controller;


import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import priv.luruidi.bean.Resource;
import priv.luruidi.bean.Score;
import priv.luruidi.bean.User;
import priv.luruidi.dao.CommentDao;
import priv.luruidi.dao.ResourceDao;
import priv.luruidi.dao.ScoreDao;
import priv.luruidi.service.CommentService;
import priv.luruidi.service.ResourceService;
import priv.luruidi.util.Page;

/**
 * @author 卢瑞迪
 * @date 2017年12月5日 下午4:38:04
 * @version V1.0
 * @Description TODO
 */
@Controller
@RequestMapping("/ResourceController")
public class ResourceController {
	@javax.annotation.Resource
	private ResourceService resourceService;
	@javax.annotation.Resource
	private CommentService commentService;
	@javax.annotation.Resource
    private ScoreDao scoreDao;
	@javax.annotation.Resource
    private ResourceDao resourceDao;
	@javax.annotation.Resource
    private CommentDao commentDao;
	@RequestMapping("/saveResource")
	public void saveResource(MultipartFile filePath,Resource resource,HttpServletResponse response,HttpSession session) throws Exception{
		String oldName = filePath.getOriginalFilename();
		String newName=new Date().getTime()+oldName;
		File file=new File("E:/upload/resourceFile",newName);
		if(!file.exists()){
			file.mkdirs();
		}
		filePath.transferTo(file);
		long byteSize = filePath.getSize();
		BigDecimal bigDecimal=new BigDecimal(byteSize);
		BigDecimal kbSize = bigDecimal.divide(new BigDecimal(1024));
		//单位为kb
		if((kbSize.compareTo(new BigDecimal(1024)))==-1){
			BigDecimal size = kbSize.setScale(2, BigDecimal.ROUND_HALF_UP);
			resource.setSize(size+"KB");
		//单位mb
		}else{
			BigDecimal mbSize = kbSize.divide(new BigDecimal(1024));
			BigDecimal size = mbSize.setScale(2,BigDecimal.ROUND_HALF_UP);
			resource.setSize(size+"MB");
		}
		resource.setFilepath(newName);
		User user = (User) session.getAttribute("user");
		resource.setUserid(user.getId());
		//下载次数初始值
		resource.setDownloadTimes(0);
		Integer count = resourceService.saveResource(resource);
		if(count==1){
            Score score = new Score();
            score.setUserid(user.getId());
            score.setScore(resource.getScore());
            score.setScoredate(new Date());
            score.setScoresource("上传名字为"+resource.getName()+"的资源");
            scoreDao.saveScoreByUserid(score);
			response.sendRedirect("../ResourceController/queryResource.action");
		}
	}
	
	@RequestMapping("/queryResource")
	public ModelAndView queryResource(Integer currentPage){
		//默认当前页为1
		if(currentPage==null){
			currentPage=1;
		}
		Integer totalCount= resourceService.queryResourceCount();
		//创建分页对象
		Page page=new Page(totalCount,currentPage,5);
		ModelAndView modelAndView=new ModelAndView();
		List<Map<String, Object>>  resourceList = resourceService.queryResource(page);
        modelAndView.addObject("flag","notLikeQuery");
		modelAndView.addObject("resourceList", resourceList);
		modelAndView.addObject("page", page);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping("/resourceDetail")
	public ModelAndView resourceDetail(Integer resourceId){
		ModelAndView modelAndView=new ModelAndView();
		Resource resource = resourceService.resourceDetail(resourceId);
		String[] keywords=resource.getKeywords().split(" ");
		modelAndView.addObject("resource", resource);
		modelAndView.addObject("keywords", keywords);
		modelAndView.setViewName("detail");
        Integer star = commentDao.queryAvgStar(resourceId);
        modelAndView.addObject("star",star);
        List<Map<String,String>> commentsList = commentService.queryComments(resourceId);
		modelAndView.addObject("commentsList", commentsList);
		return modelAndView;
	}
	@RequestMapping("/downloadResource")
	public ResponseEntity<byte[]> downloadResource(Integer resourceid) throws Exception{
		Resource resource = resourceService.resourceDetail(resourceid);
        String filepath = resource.getFilepath();
		//把保存在数据库的文件名字里的时间戳截掉
		String resourceName = filepath.substring(13);
		byte[] body=null;
		/*ServletContext servletContext = request.getServletContext();
		InputStream in = servletContext.getResourceAsStream("spring/springmvc.xml");*/
		File file=new File("E:/upload/resourceFile",filepath);
		FileInputStream in = new FileInputStream(file);
		body=new byte[in.available()];
		in.read(body);
		in.close();
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename="+resourceName);
		HttpStatus status=HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(body, headers, status);
		return responseEntity;
	}
	@RequestMapping("/likeQueryResourceListByName")
	public ModelAndView likeQueryResourceListByName(Resource resource,Integer currentPage){
        //默认当前页为1
        if(currentPage==null){
            currentPage=1;
        }
        Integer totalCount = resourceDao.countLikeQueryResourceListByName(resource);
        //创建分页对象
        Page page=new Page(totalCount,currentPage,5);
        List<Map<String, Object>> resourceList = resourceDao.likeQueryResourceListByName(page, resource);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("flag","likeQuery");
        modelAndView.addObject("name",resource.getName());
        modelAndView.addObject("resourceList", resourceList);
        modelAndView.addObject("page", page);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
