package tn.arabsoft.Rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import tn.arabsoft.Service.FluxIService;
import tn.arabsoft.entities.Flux;
import tn.arabsoft.entities.Utilisateur;

@RestController
@RequestMapping(value="/flux" )
public class FluxRest {

	private String pathFile = "D:\\PFE\\Flux\\Chargement\\";
	private String dechargementPathFile = "D:\\PFE\\Flux\\Dechargement\\";
	@Autowired
	private FluxIService fS;
	
	
	@RequestMapping("/getArticlesInventaireFile/{nameFile}")
	public JSONArray getArticleInventaireFile(@PathVariable String nameFile) throws IOException, ParseException
	{ 
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(dechargementPathFile+nameFile);
		Object obj = jsonparser.parse(reader);
		JSONArray invjsonobject = (JSONArray) obj;	
		return invjsonobject;
	}
	
	@RequestMapping("/getArticlesInventaireFileQuantite/{nameFile}")
	public JSONArray getArticleInventaireFileQuantite(@PathVariable String nameFile) throws IOException, ParseException
	{ 
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(pathFile+nameFile);
		Object obj = jsonparser.parse(reader);
		JSONArray invjsonobject = (JSONArray) obj;	
		return invjsonobject;
	}
	
	@RequestMapping("/fileUpload")
	public Flux handleFileUpload(@RequestBody Flux flux) {
		try {
			String fileName = flux.getName();
			String baseFile = flux.getContent();
			Utilisateur user = flux.getUtilisateur();
			byte[] fileBytes = baseFile.getBytes(StandardCharsets.UTF_8);//javax.xml.bind.DatatypeConverter.parseBase64Binary(baseFile);
			FileOutputStream fileOuputStream = new FileOutputStream(new File(pathFile + fileName));
			try {
				fileOuputStream.write(fileBytes);
			} finally {
				fileOuputStream.flush();
				fileOuputStream.close();
			}
			flux.setName(fileName);
			flux.setContent(baseFile);
			flux.setUtilisateur(user);
			flux.setDatechargement(new Date());
			flux.setPath(pathFile + fileName);
//			jsonFileService.save(jsonFile);
			fS.save(flux);
			return flux;
		} catch (Exception e) {
			return null;
		}
	}
	@RequestMapping("/fileDownload")
	public Flux handleFileDownload(@RequestBody Flux flux) {
		
		try {
			String fileName = flux.getName();
			String baseFile = flux.getContent();
			Utilisateur user = flux.getUtilisateur();
			byte[] fileBytes = baseFile.getBytes(StandardCharsets.UTF_8);//javax.xml.bind.DatatypeConverter.parseBase64Binary(baseFile);
			FileOutputStream fileOuputStream = new FileOutputStream(new File(dechargementPathFile + fileName));
			try {
				fileOuputStream.write(fileBytes);
				
			} finally {
				fileOuputStream.flush();
				fileOuputStream.close();
			}
			flux.setName(fileName);
			flux.setContent(baseFile);
			flux.setUtilisateur(user);
			flux.setDatechargement(new Date());
			flux.setPath(dechargementPathFile + fileName);
			fS.save(flux);
			return flux;
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value="/getFluxChargementUtilisateur/{idI}/{idU}",method=RequestMethod.GET)
	public List<Flux> getFluxChargementUtilisateur(@PathVariable int idI,@PathVariable Long idU)
	{   
		return fS.getFluxChargementUtilisateur(idI);
		
	}
	
	@RequestMapping(value="/getFluxByUserInv/{idU}/{idInv}",method=RequestMethod.GET)
	public Flux getFluxByUserInv(@PathVariable Long idU,@PathVariable int idInv)
	{   
		return fS.getFluxByUserInv(idU, idInv);
		
	}
	
	@RequestMapping(value="/getFluxDeuxByUserInv/{idU}/{idInv}",method=RequestMethod.GET)
	public Flux getFluxDeuxByUserInv(@PathVariable Long idU,@PathVariable int idInv)
	{   
		return fS.getFluxDeuxCmpByUserInv(idU, idInv);
		
	}
}
