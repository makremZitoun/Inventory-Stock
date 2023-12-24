package tn.arabsoft.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.InventaireRepository;
import tn.arabsoft.entities.EtatInv;
import tn.arabsoft.entities.Inventaire;

@Service
public class InventaireService implements InventaireIService {

	@Autowired
	private InventaireRepository iR;
	
	@Override
	public Inventaire save(Inventaire t) {
		// TODO Auto-generated method stub
		return iR.save(t);
	}

	@Override
	public List<Inventaire> getAll() {
		// TODO Auto-generated method stub
		return iR.findAll();
	}

	@Override
	public Inventaire getOne(int id) {
		// TODO Auto-generated method stub
		return iR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Inventaire updateEtatInventaire(EtatInv etatI, int idI) {
		// TODO Auto-generated method stub
		
		iR.updateEtatInventaire(etatI,idI);
		return new Inventaire();
	}
	
	@Override
	public List<Inventaire> getEtatByEtatTerminer() {
		// TODO Auto-generated method stub
		return this.iR.getEtatByEtatTerminer();
	}
	
	@Override
	public Inventaire updatedate2Inventaire(Date dateI, int idI) {
		// TODO Auto-generated method stub
		 this.iR.updatedate2Inventaire(dateI, idI);
		 return new Inventaire();
	}

}
