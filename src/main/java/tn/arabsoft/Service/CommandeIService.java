package tn.arabsoft.Service;

import tn.arabsoft.entities.Commande;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.PageCommnande;

public interface CommandeIService extends CrudService<Commande> {

	public PageCommnande getCommandeParMagasin(int idM, int page , int size);
	public PageCommnande getCommandeParUtilisateur(Long idU ,int page , int size);
	public Commande updateEtatCommande(Etat etatC,int idC);
	public PageCommnande getCommandeParMagasinEtat( int idM ,Etat etatC ,int page , int size);
	public PageCommnande getCommandeParMagasinUtilisateurEtat( int idM ,Etat etatC ,int page , int size);
	public PageCommnande getDemande( int idM ,Etat etatC ,int page , int size);
	public PageCommnande getDemandeParMagasinEtat(int idM ,Etat etatC ,int page , int size);
	
	
	
	
}
