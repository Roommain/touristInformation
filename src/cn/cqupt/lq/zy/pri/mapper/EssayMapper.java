package cn.cqupt.lq.zy.pri.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.Essay;

public interface EssayMapper {


	public int addEssay(Essay essay);

	public List<Essay> searchEssay(@Param("estitle")String estitle,@Param("esdiffernt")String esdiffernt);

	public int delEssay(@Param("esid")int esid);
	
	public int updaEssay(Essay essay);

	public List<Essay> showEssay(@Param("esdiffernt")String esdiffernt);
	
	public List<Essay> showEssayAll();
	
}
