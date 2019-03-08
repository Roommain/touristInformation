package cn.cqupt.lq.zy.pri.vo;

public class Editor {
	int editorid;
	String editorname;
	String editorpassword;
	
	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editor(int editorid, String editorname, String editorpassword) {
		super();
		this.editorid = editorid;
		this.editorname = editorname;
		this.editorpassword = editorpassword;
	}
	public int getEditorid() {
		return editorid;
	}
	public void setEditorid(int editorid) {
		this.editorid = editorid;
	}
	public String getEditorname() {
		return editorname;
	}
	public void setEditorname(String editorname) {
		this.editorname = editorname;
	}
	public String getEditorpassword() {
		return editorpassword;
	}
	public void setEditorpassword(String editorpassword) {
		this.editorpassword = editorpassword;
	}
	
	@Override
	public String toString() {
		return "Editor [editorid=" + editorid + ", editorname=" + editorname + ", editorpassword=" + editorpassword
				+ "]";
	}
	
}
