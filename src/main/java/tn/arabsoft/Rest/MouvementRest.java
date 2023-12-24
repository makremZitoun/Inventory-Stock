package tn.arabsoft.Rest;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.MouvmentStockIService;
import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.MouvementDeStock;
import tn.arabsoft.entities.MvGroupByEtat;
import tn.arabsoft.entities.MvGroupByUserAndEtat;
import tn.arabsoft.entities.PageMouvement;
import tn.arabsoft.entities.PageMouvementUtilisateur;
import tn.arabsoft.entities.PageMouvmentDate;

@RestController
@RequestMapping(value="/mouvement" )
public class MouvementRest implements CrudRest<MouvementDeStock>{

	@Autowired
	private MouvmentStockIService mS ;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public MouvementDeStock save(@RequestBody MouvementDeStock t) {
		// TODO Auto-generated method stub
		return mS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<MouvementDeStock> getAll() {
		// TODO Auto-generated method stub
		return mS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public MouvementDeStock getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return mS.getOne(id);
	}

	@RequestMapping(value="/getNbMouvement",method=RequestMethod.GET)
	public int getNbMouvement() {
		// TODO Auto-generated method stub
		return mS.getNbMouvement();
	}
	
	@RequestMapping(value="/getNbSortie",method=RequestMethod.GET)
	public int getNbSortie() {
		// TODO Auto-generated method stub
		return mS.getNbSortie();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		mS.delete(id);
		return id;
	}
	
	@RequestMapping(value="/getNbMouvementByUser_Etat",method=RequestMethod.GET)
	public List<MvGroupByUserAndEtat> getNbMouvementByUser_Etat() {
		// TODO Auto-generated method stub
		return mS.getNbMouvmentByUser_Etat();
	}

	@RequestMapping(value="/getNbMouvementByEtat",method=RequestMethod.GET)
	public List<MvGroupByEtat> getNbMouvementByEtat() {
		// TODO Auto-generated method stub
		return mS.getNBMouvmentByEtat();
	}
	
	@RequestMapping(value="/getMouvementByEtat/{etatM}",method=RequestMethod.GET)
	public List<MouvementDeStock> getMouvementByEtat(@PathVariable Etat etatM) {
		// TODO Auto-generated method stub
		return mS.getMouvementByEtat(etatM);
	}
	
	@RequestMapping(value="/getPageMouvmentByEtat/{etatM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvement getPageMouvmentByEtat(@PathVariable Etat etatM,@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return mS.getPageMouvementByEtat(etatM, page, size);
	}

	@RequestMapping(value="/getMouvementByEtatDuree/{etatM}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getMouvementByEtatDuree(@PathVariable Etat etatM , @PathVariable int idM ,@PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return mS.getMouvementByEtatDuree(etatM , idM, page, size);
	}
	
	
	@RequestMapping(value="/updateEtatMouvment/{etatM}/{idM}",method=RequestMethod.PUT)
	public MouvementDeStock updateEtatMouvment(@PathVariable Etat etatM ,@PathVariable int idM ) {
		 return mS.updateEtatMouvemnt(etatM, idM);
	}
	
	@RequestMapping(value="/updateDocumentMouvment/{idM}",method=RequestMethod.PUT)
	public MouvementDeStock updateDocumentMouvment(@RequestBody Document d  ,@PathVariable int idM ) {

		 
		 return mS.updateDocumentMouvemnt(d, idM);
		 
	}
	
	@RequestMapping(value="/getMouvementByUtilisateur/{username}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvementUtilisateur getMouvementByUtilisateur(@PathVariable String username ,@PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return mS.getMouvementByUtilisateur(username,page,size);
	}
	
	
	@RequestMapping(value="/getMouvementByTypeDuree/{typeE}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getMouvementByTypeDuree(@PathVariable String typeE,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		return mS.getMouvementByTypeDuree(typeE,idM, page, size);
	}
	
	@RequestMapping(value="/getMouvementByDateDuree/{dateM}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getMouvementByDateDuree(@PathVariable String dateM ,@PathVariable int idM ,@PathVariable int page,@PathVariable int size) throws ParseException {
		return mS.getMouvementByDateDuree(dateM,idM, page, size);
	}
	
	@RequestMapping(value="/getSortieByEtatDuree/{etatM}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getSortieByEtatDuree(@PathVariable Etat etatM , @PathVariable int idM ,@PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return mS.getSortieByEtatDuree(etatM , idM, page, size);
	}
	
	@RequestMapping(value="/getSortieByTypeDuree/{typeE}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getSortieByTypeDuree(@PathVariable String typeE,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		return mS.getSortieByTypeDuree(typeE,idM, page, size);
	}
	
	@RequestMapping(value="/getSortieByDateDuree/{dateM}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMouvmentDate getSortieByDateDuree(@PathVariable String dateM ,@PathVariable int idM ,@PathVariable int page,@PathVariable int size) throws ParseException {
		return mS.getSortieByDateDuree(dateM,idM, page, size);
	}
}
