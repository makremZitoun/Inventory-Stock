package tn.arabsoft.entities;

public class MouvementUtilisateur {

	
	private MouvementDeStock m;
    private int heure;
    private int minute;
    private int second;
	public MouvementUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MouvementUtilisateur(MouvementDeStock m, int heure, int minute, int second) {
		super();
		this.m = m;
		this.heure = heure;
		this.minute = minute;
		this.second = second;
	}
	public MouvementDeStock getM() {
		return m;
	}
	public void setM(MouvementDeStock m) {
		this.m = m;
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
		return "MouvementUtilisateur [m=" + m + ", heure=" + heure + ", minute=" + minute + ", second=" + second + "]";
	}
    
    
}
