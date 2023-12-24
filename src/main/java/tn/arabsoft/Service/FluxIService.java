package tn.arabsoft.Service;

import java.util.List;

import tn.arabsoft.entities.Flux;
public interface FluxIService extends CrudService<Flux> {

	public List<Flux> getFluxChargementUtilisateur(int idI);
	public Flux getFluxByUserInv(Long idU, int idInv);
	public Flux getFluxDeuxCmpByUserInv(Long idU,int idInv);
	
}
