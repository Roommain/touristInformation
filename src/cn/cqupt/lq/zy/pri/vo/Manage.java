package cn.cqupt.lq.zy.pri.vo;

public class Manage {

	public int getManaid() {
		return manaid;
	}
	public void setManaid(int manaid) {
		this.manaid = manaid;
	}
	public String getMananame() {
		return mananame;
	}
	public void setMananame(String mananame) {
		this.mananame = mananame;
	}
	public String getManapassword() {
		return manapassword;
	}
	public void setManapassword(String manapassword) {
		this.manapassword = manapassword;
	}
	public Manage(int manaid, String mananame, String manapassword) {
		super();
		this.manaid = manaid;
		this.mananame = mananame;
		this.manapassword = manapassword;
	}
	@Override
	public String toString() {
		return "Manage [manaid=" + manaid + ", mananame=" + mananame + ", manapassword=" + manapassword + "]";
	}
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	int manaid;
	String mananame;
	String manapassword;
}
