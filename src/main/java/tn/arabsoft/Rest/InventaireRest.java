package tn.arabsoft.Rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.InventaireIService;
import tn.arabsoft.entities.EtatInv;
import tn.arabsoft.entities.Inventaire;

@RestController
@RequestMapping(value="/inventaire")
public class InventaireRest implements CrudRest<Inventaire>{

	@Autowired
	private InventaireIService iR;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Inventaire save(@RequestBody Inventaire t) {
		// TODO Auto-generated method stub
		return iR.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Inventaire> getAll() {
		// TODO Auto-generated method stub
		return iR.getAll();
	}

	@RequestMapping(value="/getOne/{idInv}",method=RequestMethod.GET)
	@Override
	public Inventaire getOne(@PathVariable int idInv) {
		// TODO Auto-generated method stub
		return iR.getOne(idInv);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@RequestMapping(value="/updateEtatInventaire/{etatI}/{idI}",method=RequestMethod.PUT)
	public Inventaire updateEtatInventaire(@PathVariable EtatInv etatI , @PathVariable int idI)
	{		
		return this.iR.updateEtatInventaire(etatI, idI);
				
	}
	
	@RequestMapping(value="/getInventaireByEtat",method=RequestMethod.GET)
	public List<Inventaire> getInventaireByEtat()
	{		
		return this.iR.getEtatByEtatTerminer();
				
	}
	
	@RequestMapping(value="/updateDate2Inventaire/{date2}/{idI}",method=RequestMethod.PUT)
	public Inventaire updateDate2Inventaire(@PathVariable String date2 , @PathVariable int idI) throws ParseException
	{		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = df.parse(date2);
		System.out.println(date1);
		return  this.iR.updatedate2Inventaire(date1, idI);
		 
				
	}
	
	
	
}
