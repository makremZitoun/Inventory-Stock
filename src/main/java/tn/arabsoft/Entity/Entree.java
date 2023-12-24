package tn.arabsoft.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("E")
@XmlType(name="E")
public class Entree extends MouvementDeStock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="typeEntree")
	public String typeEntree;

	
	
	public String getTypeEntree() {
		return typeEntree;
	}


	public void setTypeEntree(String typeEntree) {
		this.typeEntree = typeEntree;
	}

	

	public Entree(String typeEntree) {
		super();
		this.typeEntree = typeEntree;
	}


	public Entree() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Entree(int id, int numero, String referenceMouvement, String observationMouvement, Date dateMouvement,
			Etat etat, tn.arabsoft.entities.Utilisateur utilisateur, Commande commande, Document document) {
		super(id, numero, referenceMouvement, observationMouvement, dateMouvement, etat, utilisateur, commande, document);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
}
