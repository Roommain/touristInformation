package cn.cqupt.lq.zy.pri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cqupt.lq.zy.pri.mapper.ManageMapper;
import cn.cqupt.lq.zy.pri.servic.Manageservice;
import cn.cqupt.lq.zy.pri.vo.Manage;
@Service
public class Manageserviceimpl implements Manageservice {
	@Autowired
	private ManageMapper manageMapper;
	@Override
	public Manage selectmanage(Manage manage) {
		return manageMapper.selectmanage(manage);
	}

}
