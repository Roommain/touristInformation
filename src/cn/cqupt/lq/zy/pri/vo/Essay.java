package cn.cqupt.lq.zy.pri.vo;

import java.util.Date;

public class Essay {
	int esid;
	String estitle;
	String esmessage;
	String esdate;
	String espicture;
	String esdiffernt;
	int eslevel;
	String esfacepicture;
	
	@Override
	public String toString() {
		return "Essay [esid=" + esid + ", estitle=" + estitle + ", esmessage=" + esmessage + ", esdate=" + esdate
				+ ", espicture=" + espicture + ", esdiffernt=" + esdiffernt + ", eslevel="
				+ eslevel + ", esfacepicture=" + esfacepicture + "]";
	}
	
	public Essay(int esid, String estitle, String esmessage, String esdate, String espicture,
			String esdiffernt, int eslevel, String esfacepicture) {
		super();
		this.esid = esid;
		this.estitle = estitle;
		this.esmessage = esmessage;
		this.esdate = esdate;
		this.espicture = espicture;
		this.esdiffernt = esdiffernt;
		this.eslevel = eslevel;
		this.esfacepicture = esfacepicture;
	}
	public String getEsfacepicture() {
		return esfacepicture;
	}
	public void setEsfacepicture(String esfacepicture) {
		this.esfacepicture = esfacepicture;
	}

	public Essay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEsid() {
		return esid;
	}
	public void setEsid(int esid) {
		this.esid = esid;
	}
	public String getEstitle() {
		return estitle;
	}
	public void setEstitle(String estitle) {
		this.estitle = estitle;
	}
	public String getEsmessage() {
		return esmessage;
	}
	public void setEsmessage(String esmessage) {
		this.esmessage = esmessage;
	}
	public String getEsdate() {
		return esdate;
	}
	public void setEsdate(String dateNowStr) {
		this.esdate = dateNowStr;
	}
	public String getEspicture() {
		return espicture;
	}
	public void setEspicture(String espicture) {
		this.espicture = espicture;
	}
	public String getEsdiffernt() {
		return esdiffernt;
	}
	public void setEsdiffernt(String esdiffernt) {
		this.esdiffernt = esdiffernt;
	}
	public int getEslevel() {
		return eslevel;
	}
	public void setEslevel(int eslevel) {
		this.eslevel = eslevel;
	}

}
