package cn.cqupt.lq.zy.pri.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.cqupt.lq.zy.pri.servic.Essayservice;
import cn.cqupt.lq.zy.pri.servic.Historyservice;
import cn.cqupt.lq.zy.pri.vo.Essay;
import cn.cqupt.lq.zy.pri.vo.History;

@Controller
public class EssayController {
      @Autowired
      private Essayservice essayservice;
      @Autowired
      private Historyservice historyservice;
      @RequestMapping(value="/addEssay" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      //,@RequestParam("someone")String someone
   	  public int addEssay(@RequestBody Essay essay){
    	  int result=essayservice.addEssay(essay);
    	  if(result!=0){
    		  History history=new History();
 			 String dosomething="someone"+"发表了文章《"+essay.getEstitle()+"》";
 			 history.setHpeosomething(dosomething);
 			 Date d = new Date();       //获取当前时间
 			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
 		     String dateNowStr = sdf.format(d); 
 		    history.setHtime(dateNowStr);
 		    historyservice.addhistory(history);
 		    return 1;
    	  }
    	  
    	  return 0;
      }
      
      @RequestMapping(value="/SearchEssay" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public PageInfo<Essay> searchEssay(@RequestParam("pageNum")int pageNum,@RequestParam("estitle")String estitle,@RequestParam("esdifferent")String esdifferent){
    	  int pagesize=10;
    	  System.out.println("22222222222"+estitle);
    	  PageHelper.startPage(pageNum,pagesize);  
    	  List<Essay> essaylist=essayservice.searchEssay(estitle,esdifferent);
    	  PageInfo<Essay> pageessay=new PageInfo<Essay>(essaylist);
    	  return pageessay;
      }
      
      
      @RequestMapping(value="/delEssay" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public int delEssay(@RequestParam("aesid")int aesid,@RequestParam("estitle")String estitle,@RequestParam("someone")String someone){
    	  int result=essayservice.delEssay(aesid);
    	  if(result!=0){
    		  History history=new History();
 			 String dosomething=someone+"删除了文章《"+estitle+"》";
 			 history.setHpeosomething(dosomething);
 			 Date d = new Date();       //获取当前时间
 			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
 		     String dateNowStr = sdf.format(d); 
 		    history.setHtime(dateNowStr);
 		    historyservice.addhistory(history);
 		    return 1;
    	  }
    	  return 0;
      }
      //@RequestParam("someone")String someone
      @RequestMapping(value="/updaEssay" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public int updaEssay(@RequestBody Essay essay){
    	  Date d = new Date();       //获取当前时间
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		     String dateNowStr = sdf.format(d); 
    	  essay.setEsdate(dateNowStr);
    	  int result=essayservice.updaEssay(essay);
    	  if(result!=0){
    		  History history=new History();
 			 String dosomething="someone"+"修改了文章《"+essay.getEstitle()+"》";
 			 history.setHpeosomething(dosomething);
 			
 		    history.setHtime(dateNowStr);
 		    historyservice.addhistory(history);
 		    return 1;
    	  }
    	  return 0; 
      }
      
      @RequestMapping(value="/showEssay" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public PageInfo<Essay> showEssay(@RequestParam("pageNum")int pageNum,@RequestParam("esdifferent")String esdifferent){
    	  int pagesize=10;
    	  PageHelper.startPage(pageNum,pagesize);  
    	  List<Essay> essaylist=essayservice.showEssay(esdifferent);
    	  PageInfo<Essay> pageessay=new PageInfo<Essay>(essaylist);
    	  return pageessay;
      }
      
      @RequestMapping(value="/showEssayAll" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public PageInfo<Essay> showEssayAll(@RequestParam("pageNum")int pageNum){
    	  int pagesize=10;
    	  System.out.println("fdgfshghghgfh"+pageNum);
    	  PageHelper.startPage(pageNum,pagesize);  
    	  List<Essay> essaylist=essayservice.showEssayAll();
    	  PageInfo<Essay> pageessay=new PageInfo<Essay>(essaylist);
    	  return pageessay;
      }
      /*
      @RequestMapping(value="/uploadpicture" ,method={RequestMethod.GET,RequestMethod.POST})
      @ResponseBody
      public String uploadpicture(MultipartFile multipartFile){
    	  if(multipartFile!=null){
    		   String realpath="D:\\";
    		   String fileName=multipartFile.getOriginalFilename();// 文件原名称
    		   String poname=UUID.randomUUID().toString().replace("-", "")+fileName.substring(fileName.lastIndexOf("."));
      		   File flie=new File(realpath+poname);
      		 try {
				multipartFile.transferTo(flie);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		 
      		 String jiapath="http:xxx"+"/picture"+poname;
      		 return jiapath;
    	  }
    	  return null;
      }
      */
}
