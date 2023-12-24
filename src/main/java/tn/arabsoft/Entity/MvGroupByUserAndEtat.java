package tn.arabsoft.entities;

public class MvGroupByUserAndEtat {

	  private String username;
	  private Etat etat;
	  private Long  cnt;
	
	public MvGroupByUserAndEtat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MvGroupByUserAndEtat(String username, Etat etat, Long cnt) {
		super();
		this.username = username;
		this.etat = etat;
		this.cnt = cnt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	
	
	  
}
