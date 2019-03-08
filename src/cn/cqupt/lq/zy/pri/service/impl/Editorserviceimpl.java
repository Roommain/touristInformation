package cn.cqupt.lq.zy.pri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cqupt.lq.zy.pri.mapper.EditorMapper;
import cn.cqupt.lq.zy.pri.servic.Editorservice;
import cn.cqupt.lq.zy.pri.vo.Editor;
@Service
public class Editorserviceimpl implements Editorservice {
	@Autowired
	private EditorMapper editorMapper;
	@Override
	public Editor selectEditor(Editor editor) {
		return editorMapper.selectEditor(editor);
		
	}

}
