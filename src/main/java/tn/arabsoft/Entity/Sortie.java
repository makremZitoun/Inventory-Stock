package tn.arabsoft.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("S")
@XmlType(name="S")
public class Sortie extends MouvementDeStock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="typeSortie")
	public String typeSortie;

	
	
	
	public String getTypeSortie() {
		return typeSortie;
	}

	public void setTypeSortie(String typeSortie) {
		this.typeSortie = typeSortie;
	}

	public Sortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sortie(int id, int numero, String referenceMouvement, String observationMouvement, Date dateMouvement,
			Etat etat, tn.arabsoft.entities.Utilisateur utilisateur, Commande commande, Document document) {
		super(id, numero, referenceMouvement, observationMouvement, dateMouvement, etat, utilisateur, commande, document);
		// TODO Auto-generated constructor stub
	}

	

	
	

	
}
