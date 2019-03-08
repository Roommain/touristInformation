package cn.cqupt.lq.zy.pri.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cqupt.lq.zy.pri.servic.Historyservice;
import cn.cqupt.lq.zy.pri.servic.Manageservice;
import cn.cqupt.lq.zy.pri.vo.Editor;
import cn.cqupt.lq.zy.pri.vo.History;
import cn.cqupt.lq.zy.pri.vo.Manage;

@Controller
public class ManageController {

	@Autowired
	private Manageservice manageservice;
	@Autowired
	private Historyservice historyservice;
	@RequestMapping(value="/managelogin" ,method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Manage manageLogin(@RequestParam("manageName")String manageName,@RequestParam("password")String managepassword){
		Manage manage=new Manage();
		manage.setMananame(manageName);
		manage.setManapassword(managepassword);
		Manage manage2=manageservice.selectmanage(manage);//登录
		 if(manage2!=null){  //登录成功就添加历史记录
			 History history=new History();
			 String dosomething="管理员"+manageName+"登录成功";
			 history.setHpeosomething(dosomething);
			 Date d = new Date();       //获取当前时间
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		     String dateNowStr = sdf.format(d);  
			 history.setHtime(dateNowStr);
			 historyservice.addhistory(history);
			 return manage2;
			 
		 }
			 return null;
	}
}

