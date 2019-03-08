package cn.cqupt.lq.zy.pri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cqupt.lq.zy.pri.mapper.InterfacenMapper;
import cn.cqupt.lq.zy.pri.servic.Interfacenservice;
import cn.cqupt.lq.zy.pri.vo.Interfacen;
@Service
public class Interfacenserviceimpl implements Interfacenservice {
    @Autowired
    private InterfacenMapper interfacenmapper;
	@Override
	public int addInterfacen(Interfacen interfacen) {
		// TODO Auto-generated method stub
		return interfacenmapper.addInterfacen(interfacen);
	}

	@Override
	public List<Interfacen> searchInterfacen(String esid) {
		// TODO Auto-generated method stub
		return interfacenmapper.searchInterfacen(esid);
	}

	@Override
	public int delInterfacen(int esid) {
		// TODO Auto-generated method stub
		return interfacenmapper.delInterfacen(esid);
	}

	@Override
	public int updaInterfacen(Interfacen interfacen) {
		// TODO Auto-generated method stub
		return interfacenmapper.updaInterfacen(interfacen);
	}

	@Override
	public List<Interfacen> showInterfacen() {
		// TODO Auto-generated method stub
		return interfacenmapper.showInterfacen();
	}

}
