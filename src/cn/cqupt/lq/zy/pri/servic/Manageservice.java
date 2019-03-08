package cn.cqupt.lq.zy.pri.servic;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.Editor;
import cn.cqupt.lq.zy.pri.vo.Manage;

public interface Manageservice {
	public Manage selectmanage(@Param("Manage")Manage manage);
}
