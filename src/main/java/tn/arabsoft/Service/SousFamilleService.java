package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.SousFamilleRepository;
import tn.arabsoft.entities.SousFamille;

@Service
public class SousFamilleService implements SousFamilleIService {

	@Autowired
	private SousFamilleRepository scp ;
	
	@Override
	public SousFamille save(SousFamille t) {
		// TODO Auto-generated method stub
		this.scp.save(t) ;
		return t;
	}

	@Override
	public List<SousFamille> getAll() {
		// TODO Auto-generated method stub
		return this.scp.findAll();
	}

	@Override
	public SousFamille getOne(int id) {
		// TODO Auto-generated method stub
		return this.scp.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		 this.scp.deleteById(id);
		 return id ;
	}

	@Override
	public SousFamille getSousFamilleByNom(String nomDeSousCategorie) {
		// TODO Auto-generated method stub
		return this.scp.getSousFamilleByNom(nomDeSousCategorie);
	}

	@Override
	public List<SousFamille> getsousFamilleBynomFamille(String nomCategorie) {
		// TODO Auto-generated method stub
		return this.scp.getsousFamilleBynomFamille(nomCategorie);
	}

}
