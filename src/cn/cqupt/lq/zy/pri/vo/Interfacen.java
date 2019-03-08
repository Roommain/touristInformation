package cn.cqupt.lq.zy.pri.vo;

public class Interfacen {

	@Override
	public String toString() {
		return "Interfacen [interid=" + interid + ", intername=" + intername + ", interaddress=" + interaddress
				+ ", interprir=" + interprir + ", intertime=" + intertime + "]";
	}
	public Interfacen(int interid, String intername, String interaddress, int interprir, String intertime) {
		super();
		this.interid = interid;
		this.intername = intername;
		this.interaddress = interaddress;
		this.interprir = interprir;
		this.intertime = intertime;
	}
	public Interfacen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInterid() {
		return interid;
	}
	public void setInterid(int interid) {
		this.interid = interid;
	}
	public String getIntername() {
		return intername;
	}
	public void setIntername(String intername) {
		this.intername = intername;
	}
	public String getInteraddress() {
		return interaddress;
	}
	public void setInteraddress(String interaddress) {
		this.interaddress = interaddress;
	}
	public int getInterprir() {
		return interprir;
	}
	public void setInterprir(int interprir) {
		this.interprir = interprir;
	}
	public String getIntertime() {
		return intertime;
	}
	public void setIntertime(String intertime) {
		this.intertime = intertime;
	}
	
	int interid;
	String intername;
	String interaddress;
	int interprir;
	String intertime; 
}
