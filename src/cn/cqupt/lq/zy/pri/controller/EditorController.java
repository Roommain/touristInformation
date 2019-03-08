package cn.cqupt.lq.zy.pri.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cqupt.lq.zy.pri.servic.Editorservice;
import cn.cqupt.lq.zy.pri.servic.Historyservice;
import cn.cqupt.lq.zy.pri.vo.Editor;
import cn.cqupt.lq.zy.pri.vo.History;

@Controller
public class EditorController {
	@Autowired
	private Editorservice editorservice;
	@Autowired
	private Historyservice historyservice;
	@RequestMapping(value="/editorlogin" ,method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Editor editorLogin(@RequestParam("editorName")String editorName,@RequestParam("password")String editorpassword){
		Editor editor=new Editor();
		editor.setEditorname(editorName);
		editor.setEditorpassword(editorpassword);
		Editor editor2=editorservice.selectEditor(editor);      //登录
		 if(editor2!=null){  //登录成功就添加历史记录
			 History history=new History();
			 String dosomething="编辑员"+editorName+"登录成功";
			 history.setHpeosomething(dosomething);
			 Date d = new Date();       //获取当前时间
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		     String dateNowStr = sdf.format(d);  
			 history.setHtime(dateNowStr);
			 historyservice.addhistory(history);
			 return editor2;
			 
		 }
			 return null;
	}
	
}
