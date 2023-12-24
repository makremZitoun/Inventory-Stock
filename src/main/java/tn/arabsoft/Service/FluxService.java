package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.FluxRepository;
import tn.arabsoft.entities.Flux;

@Service
public class FluxService implements FluxIService {


	@Autowired
	private FluxRepository fR;
	
	@Override
	public Flux save(Flux t) {
		// TODO Auto-generated method stub
		return fR.save(t);
	}

	@Override
	public List<Flux> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Flux> getFluxChargementUtilisateur(int idI) {
		// TODO Auto-generated method stub
		
		return fR.getFluxChargementUtilisateur(idI);
	}
	
	@Override
	public Flux getFluxByUserInv(Long idU, int idInv) {
		// TODO Auto-generated method stub
		return fR.getFluxByUserInv(idU, idInv);
	}
	
	@Override
	public Flux getFluxDeuxCmpByUserInv(Long idU, int idInv) {
		// TODO Auto-generated method stub
		return fR.getFluxDeuxCmpByUserInv(idU, idInv);
	}

}
