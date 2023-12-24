package tn.arabsoft.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("II")
@XmlType(name="II")
public class Inopine extends Inventaire{

	public Inopine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inopine(int idI, int numeroInventaire, EtatInv etat, Date dateInventaire, Magasin magasin,
			List<Comptage> listComptage) {
		super(idI, numeroInventaire, etat, dateInventaire, magasin, listComptage);
		// TODO Auto-generated constructor stub
	}

	



	
	
	
	
	
	
}
