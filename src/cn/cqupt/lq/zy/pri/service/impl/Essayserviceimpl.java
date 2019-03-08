package cn.cqupt.lq.zy.pri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cqupt.lq.zy.pri.mapper.EssayMapper;
import cn.cqupt.lq.zy.pri.servic.Essayservice;
import cn.cqupt.lq.zy.pri.vo.Essay;
@Service
public class Essayserviceimpl implements Essayservice {
    @Autowired
    private EssayMapper essayMapper;
	@Override
	public int addEssay(Essay essay) {
		return essayMapper.addEssay(essay);
	}

	@Override
	public int delEssay(int esid) {
		return essayMapper.delEssay(esid);
	}

	@Override
	public int updaEssay(Essay essay) {
		return essayMapper.updaEssay(essay);
	}

	@Override
	public List<Essay> searchEssay(String estitle, String esdiffernt) {
		// TODO Auto-generated method stub
		return essayMapper.searchEssay(estitle, esdiffernt);
	}

	@Override
	public List<Essay> showEssay(String esdiffernt) {
		// TODO Auto-generated method stub
		return essayMapper.showEssay(esdiffernt);
	}

	@Override
	public List<Essay> showEssayAll() {
		// TODO Auto-generated method stub
		return essayMapper.showEssayAll();
	}

}
