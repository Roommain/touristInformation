package cn.cqupt.lq.zy.pri.mapper;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.Editor;

public interface EditorMapper {
       public Editor selectEditor(@Param("Editor")Editor editor);
	
}
