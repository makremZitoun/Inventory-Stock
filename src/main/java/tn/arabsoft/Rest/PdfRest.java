package tn.arabsoft.Rest;

import org.springframework.beans.factory.annotation.Autowired;

import tn.arabsoft.Service.FicheStockIservice;
import tn.arabsoft.Service.MagasinIService;
import tn.arabsoft.Service.PdfGenerator;
import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.Magasin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
 
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping("/api/pdf")
public class PdfRest {
	
	@Autowired
	private MagasinIService caS;
	
	@Autowired
	private FicheStockIservice fsS;
	
	 @GetMapping(value = "/boncommande",
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
	        List<Magasin> customers =  caS.getAll();
	 
	        ByteArrayInputStream bis = PdfGenerator.customerPDFReport(customers);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=boncommande.pdf");
	 
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 @GetMapping(value = "/bonSortie/{idMV}",
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> bonSortieReport(@PathVariable int idMV) throws IOException {
		 List<FicheStock> customers =  fsS.getFicheStockByMouvement(idMV);
	 
	        ByteArrayInputStream bis = PdfGenerator.bonSortiePDFReport(customers);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=bonsortie.pdf");
	 
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 @GetMapping(value = "/bonEntree/{idMV}",
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> bonEntreeReport(@PathVariable int idMV) throws IOException {
	        List<FicheStock> customers =  fsS.getFicheStockByMouvement(idMV);
	 
	        ByteArrayInputStream bis = PdfGenerator.bonEntreePDFReport(customers);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=bonsortie.pdf");
	 
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }

}
