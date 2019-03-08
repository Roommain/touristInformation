package cn.cqupt.lq.zy.pri.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.cqupt.lq.zy.pri.servic.Historyservice;
import cn.cqupt.lq.zy.pri.vo.History;

@Controller
public class HistoryController {
    @Autowired
	private Historyservice historyservice;
    @RequestMapping("showHistory")
    @ResponseBody
    public PageInfo showHistory(@RequestParam("pageNum")int pageNum){
    	int pageSize=10;
    	 //引入分页查询，使用PageHelper分页功能  
        //在查询之前传入当前页，然后多少记录  
        PageHelper.startPage(pageNum,pageSize,"htime DESC");  
        //startPage后紧跟的这个查询就是分页查询  
    	List<History> historylist=historyservice.showHisotory();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
        PageInfo<History> pageInfo = new PageInfo<History>(historylist);  
    	return pageInfo;
    }
	
}
