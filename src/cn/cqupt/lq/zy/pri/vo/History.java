package cn.cqupt.lq.zy.pri.vo;

public class History {

	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHpeosomething() {
		return hpeosomething;
	}
	public void setHpeosomething(String hpeosomething) {
		this.hpeosomething = hpeosomething;
	}
	public String getHtime() {
		return htime;
	}
	public void setHtime(String htime) {
		this.htime = htime;
	}
	@Override
	public String toString() {
		return "History [hid=" + hid + ", hpeosomething=" + hpeosomething + ", htime=" + htime + "]";
	}
	public History(int hid, String hpeosomething, String htime) {
		super();
		this.hid = hid;
		this.hpeosomething = hpeosomething;
		this.htime = htime;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	int hid;
	String hpeosomething;
	String htime;
}
