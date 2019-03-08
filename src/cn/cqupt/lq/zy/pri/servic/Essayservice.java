package cn.cqupt.lq.zy.pri.servic;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.cqupt.lq.zy.pri.vo.Essay;

public interface Essayservice {
	//��������
		public int addEssay(@Param("Essay")Essay essay);
		
		public List<Essay> searchEssay(@Param("estitle")String estitle,@Param("esdiffernt")String esdiffernt);

		public int delEssay(@Param("esid")int esid);
		
		public int updaEssay(Essay essay);

		public List<Essay> showEssay(@Param("esdiffernt")String esdiffernt);
		
		public List<Essay> showEssayAll();
}
