package cn.cqupt.lq.zy.pri.servic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.Interfacen;

public interface Interfacenservice {
	public int addInterfacen(Interfacen interfacen);

	public List<Interfacen> searchInterfacen(@Param("intername")String intername);

	public int delInterfacen(@Param("interid")int interid);
	
	public int updaInterfacen(Interfacen interfacen);

	public List<Interfacen> showInterfacen();
}
