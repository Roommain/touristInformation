package cn.cqupt.lq.zy.pri.servic;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.Editor;

public interface Editorservice {
	public Editor selectEditor(@Param("Editor")Editor editor);
}
