package tn.arabsoft.entities;

public class MvCmdDelai {
	
	private MouvementDeStock mv;
	private Commande cmd ;
	private Materiel ar;
    private int heure;
    private int minute;
    private int second;
    
    
    
	public MvCmdDelai(MouvementDeStock mv, Commande cmd, Materiel ar, int heure, int minute, int second) {
		super();
		this.mv = mv;
		this.cmd = cmd;
		this.ar = ar;
		this.heure = heure;
		this.minute = minute;
		this.second = second;
	}
	public MvCmdDelai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MouvementDeStock getMv() {
		return mv;
	}
	public void setMv(MouvementDeStock mv) {
		this.mv = mv;
	}
	public Commande getCmd() {
		return cmd;
	}
	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}
	public Materiel getAr() {
		return ar;
	}
	public void setAr(Materiel ar) {
		this.ar = ar;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	@Override
	public String toString() {
		return "MvCmdDelai [mv=" + mv + ", cmd=" + cmd + ", ar=" + ar + ", heure=" + heure + ", minute=" + minute
				+ ", second=" + second + "]";
	}
    
    

}
