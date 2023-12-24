package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.CommandeRepository;
import tn.arabsoft.entities.Commande;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.PageCommnande;

@Service
public class CommandeService implements CommandeIService{
	
	@Autowired
	private CommandeRepository cR ;

	@Override
	public Commande save(Commande t) {
		// TODO Auto-generated method stub
		return cR.save(t);
	}

	@Override
	public List<Commande> getAll() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public Commande getOne(int id) {
		// TODO Auto-generated method stub
		return cR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		 cR.deleteById(id);
		 return id ;
	}

	@Override
	public PageCommnande getCommandeParMagasin(int idM, int page, int size) {
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<Commande> ops = cR.getCommandeParMagasin(idM,sortedByReference);
      PageCommnande pp =  new PageCommnande();
      pp.setCommandes(ops.getContent());
      pp.setNbOperations(ops.getNumberOfElements());
      pp.setPage(ops.getNumber());
      pp.setTotalPage(ops.getTotalPages());
      pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}

	@Override
	public PageCommnande getCommandeParUtilisateur(Long idU,int page , int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<Commande> ops = cR.getCommandeParUtilisateur(idU,sortedByReference);
    PageCommnande pp =  new PageCommnande();
    pp.setCommandes(ops.getContent());
    pp.setNbOperations(ops.getNumberOfElements());
    pp.setPage(ops.getNumber());
    pp.setTotalPage(ops.getTotalPages());
    pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}

	@Override
	public Commande updateEtatCommande(Etat etatC, int idC) {
		// TODO Auto-generated method stub
		cR.updateEtatCommande(etatC, idC);
		return this.getOne(idC);
	}
	

	@Override
	public PageCommnande getCommandeParMagasinEtat(int idM,Etat etatC, int page, int size) {
	
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<Commande> ops = cR.getCommandeParMagasinEtat(idM,etatC,sortedByReference);
    PageCommnande pp = new PageCommnande();
    pp.setCommandes(ops.getContent());
    pp.setNbOperations(ops.getNumberOfElements());
    pp.setPage(ops.getNumber());
    pp.setTotalPage(ops.getTotalPages());
    pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	
	}
	
	
	@Override
	public PageCommnande getCommandeParMagasinUtilisateurEtat(int idM, Etat etatC, int page, int size) {
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<Commande> ops = cR.getCommandeParMagasinUtilisateurEtat(idM,etatC,sortedByReference);
    PageCommnande pp = new PageCommnande();
    pp.setCommandes(ops.getContent());
    pp.setNbOperations(ops.getNumberOfElements());
    pp.setPage(ops.getNumber());
    pp.setTotalPage(ops.getTotalPages());
    pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}

	@Override
	public PageCommnande getDemande(int idM, Etat etatC, int page, int size) {
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<Commande> ops = cR.getDemande(idM,etatC,sortedByReference);
    PageCommnande pp = new PageCommnande();
    pp.setCommandes(ops.getContent());
    pp.setNbOperations(ops.getNumberOfElements());
    pp.setPage(ops.getNumber());
    pp.setTotalPage(ops.getTotalPages());
    pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}

@Override
	public PageCommnande getDemandeParMagasinEtat(int idM, Etat etatC, int page, int size) {
	Pageable sortedByReference =  PageRequest.of(page, size);
	Page<Commande> ops = cR.getDemandeParMagasinEtat(idM,etatC,sortedByReference);
PageCommnande pp = new PageCommnande();
pp.setCommandes(ops.getContent());
pp.setNbOperations(ops.getNumberOfElements());
pp.setPage(ops.getNumber());
pp.setTotalPage(ops.getTotalPages());
pp.setTotalOperation((int)ops.getTotalElements());
	return pp;
	}
}
