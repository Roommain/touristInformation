package cn.cqupt.lq.zy.pri.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.cqupt.lq.zy.pri.servic.*;
import cn.cqupt.lq.zy.pri.vo.History;
import cn.cqupt.lq.zy.pri.vo.Interfacen;
@Controller
public class InterfacenController {
    	@Autowired
        private Interfacenservice interfacenservice;
    	 @Autowired
         private Historyservice historyservice;
         @RequestMapping(value="/addInterfacen" ,method={RequestMethod.GET,RequestMethod.POST})
         @ResponseBody
      	  public int addInterfacen(@RequestBody Interfacen interfacen,@RequestParam("someone")String someone){
       	  int result=interfacenservice.addInterfacen(interfacen);
       	  if(result!=0){
       		     History history=new History();
    			 String dosomething=someone+"添加了接口《"+interfacen.getIntername()+"》";
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
         
         
         @RequestMapping(value="/delInterfacen" ,method={RequestMethod.GET,RequestMethod.POST})
         @ResponseBody
         public int delInterfacen(@RequestParam("Interfacenid")int Interfacenid,@RequestParam("Interfacentitle")String Interfacentitle,@RequestParam("someone")String someone){
       	  int result=interfacenservice.delInterfacen(Interfacenid);
       	  if(result!=0){
       		  History history=new History();
    			 String dosomething=someone+"删除了接口《"+Interfacentitle+"》";
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
         
         @RequestMapping(value="/updaInterfacen" ,method={RequestMethod.GET,RequestMethod.POST})
         @ResponseBody
         public int updaInterfacen(@RequestBody Interfacen interfacen,@RequestParam("someone")String someone){
       	    Date d = new Date();    //获取当前时间
   			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
   		     String dateNowStr = sdf.format(d); 
   		     interfacen.setIntertime(dateNowStr);
       	  int result=interfacenservice.updaInterfacen(interfacen);
       	  if(result!=0){
       		    History history=new History();
    			String dosomething=someone+"修改了接口《"+interfacen.getIntername()+"》";
    		    history.setHpeosomething(dosomething);	
    		    history.setHtime(dateNowStr);
    		    historyservice.addhistory(history);
    		    return 1;
       	  }
       	  return 0; 
         }
         
         @RequestMapping(value="/showInterfacen" ,method={RequestMethod.GET,RequestMethod.POST})
         @ResponseBody
         public PageInfo<Interfacen> showInterfacen(@RequestParam("pageNum")int pageNum){
       	  int pagesize=10;
       	  PageHelper.startPage(pageNum,pagesize);
       	  List<Interfacen> interfacenlist=interfacenservice.showInterfacen();
       	  PageInfo<Interfacen> pageessay=new PageInfo<Interfacen>(interfacenlist);
       	  return pageessay;
         }
         
         @RequestMapping(value="/searchInterfacen" ,method={RequestMethod.GET,RequestMethod.POST})
         @ResponseBody
    	 public PageInfo<Interfacen> searchInterfacen(@RequestParam("pageNum")int pageNum,@RequestParam("intertitle")String intertitle){
    		 int pagesize=10;
       	  PageHelper.startPage(pageNum,pagesize);  
       	  List<Interfacen> intertitlelist=interfacenservice.searchInterfacen(intertitle);
       	  PageInfo<Interfacen> pageInterfacen=new PageInfo<Interfacen>(intertitlelist);
       	  return pageInterfacen;
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
}
