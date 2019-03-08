package cn.cqupt.lq.zy.pri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cqupt.lq.zy.pri.mapper.HistoryMapper;
import cn.cqupt.lq.zy.pri.servic.Historyservice;
import cn.cqupt.lq.zy.pri.vo.History;
@Service
public class Historyserviceimpl implements Historyservice {

	@Autowired
	private HistoryMapper historymapper;
	@Override
	public int addhistory(History history) {
		return historymapper.addhistory(history);
	}

	@Override
	public List<History> showHisotory() {
		return historymapper.showHisotory();
	}

}
