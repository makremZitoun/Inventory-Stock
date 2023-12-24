package tn.arabsoft.Service;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import tn.arabsoft.entities.Entree;
import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.Magasin;
import tn.arabsoft.entities.MouvementDeStock;
import tn.arabsoft.entities.Sortie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import javax.print.DocFlavor.STRING;
public class PdfGenerator {
	
	 
//	  private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
	  
	  public static ByteArrayInputStream customerPDFReport(List<Magasin> customers) {
	    Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        try {
	          
	          PdfWriter.getInstance(document, out);
	            document.open();
	          
	            // Add Text to PDF file ->
	          Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	          Paragraph para = new Paragraph( "Customer Table", font);
	          para.setAlignment(Element.ALIGN_CENTER);
	          document.add(para);
	          document.add(Chunk.NEWLINE);
	          float[] columnWidths = {1, 5, 5};
	          PdfPTable table = new PdfPTable(columnWidths);
	          // Add PDF Table Header ->
	            Stream.of("ID", "First Name", "Last Name")
	              .forEach(headerTitle -> {
	                  PdfPCell header = new PdfPCell();
	                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
	                  header.setBorderWidth(2);
	                  header.setPhrase(new Phrase(headerTitle, headFont));
	                  table.addCell(header);
	              });
	            
	            for (Magasin customer : customers) {
	              PdfPCell idCell = new PdfPCell(new Phrase(customer.getId()));
	              idCell.setPaddingLeft(4);
	              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(idCell);
	 
	                PdfPCell firstNameCell = new PdfPCell(new Phrase(customer.getId()));
	                firstNameCell.setPaddingLeft(4);
	                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(firstNameCell);
	 
	                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(customer.getDesignationMagasin())));
	                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                lastNameCell.setPaddingRight(4);
	                table.addCell(lastNameCell);
	            }
	            document.add(table);
	            
	            document.close();
	        }catch(DocumentException e) {
//	          logger.error(e.toString());
	        }
	        
	    return new ByteArrayInputStream(out.toByteArray());
	  }

	  
/*******************************/
	  public static ByteArrayInputStream bonSortiePDFReport(List<FicheStock> customers) {
		  Document document = new Document();
		    DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        Chunk glue = new Chunk(new VerticalPositionMark());
		        
		       Sortie mv = (Sortie) customers.get(0).getMouvmentDeStock(); 
		        try {
		          
		          PdfWriter.getInstance(document, out);
		            document.open();
		          
		            // Add Text to PDF file ->
		            /*******************/
		          Font font0 = FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.DARK_GRAY);
		          Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);
		          Font font1 = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLUE);
		          Paragraph para = new Paragraph( "Bon Sortie Stock " , font0);
		          para.setAlignment(Element.ALIGN_CENTER);
		          document.add(para);
		          document.add(Chunk.NEWLINE);
		          /*******************/
		          Paragraph para1 = new Paragraph( "N° de l'Sortie", font);
		          Paragraph para11 = new Paragraph(Integer.toString(mv.numero), font1);
		          para1.add(glue);
		          para1.add("Magasin");
		          para11.add(glue);
		          para11.add(mv.getUtilisateur().getMagasin().getDesignationMagasin());
		          /*******************/
		          Paragraph para2 = new Paragraph( "Référence de l'Sortie",font );
		          Paragraph para22 = new Paragraph( mv.referenceMouvement, font1);
		          para2.add(glue);
		          para2.add("Date de l'Sortie");
		          para22.add(glue);
		          para22.add(df.format(mv.getDateMouvement()));
		          /*******************/
		          Paragraph para3 = new Paragraph( "Nature de l'Sortie",font);
		          Paragraph para33 = new Paragraph(mv.getTypeSortie(), font1);
		          para3.add(glue);
		          para3.add("Magasinier");
		          para33.add(glue);
		          para33.add(mv.getUtilisateur().getUserName());
		          /*******************/
		          Paragraph para5 = new Paragraph( "Informations sur l'Sortie",font);
		          para5.setAlignment(Element.ALIGN_CENTER);
		          para.setAlignment(Element.ALIGN_CENTER); 
		          document.add(para2);
		          document.add(para22);
		          document.add(para3);
		          document.add(para33);
		          document.add(para1);
		          document.add(para11);
		          document.add(para5);
		          document.add(Chunk.NEWLINE);
		          
//		          Paragraph para4 = new Paragraph( "Date de l'entrée", font);
//		          Paragraph para44 = new Paragraph( df.format(mv.getDateMouvement()), font);
//		          para4.setAlignment(Element.ALIGN_RIGHT);
//		          para44.setAlignment(Element.ALIGN_RIGHT);
//		          document.add(para4);
//		          document.add(para44);
		          
		          /******************/
		          float[] columnWidths = {1,1};
		          PdfPTable table = new PdfPTable(columnWidths);
		          // Add PDF Table Header ->
		          
		            Stream.of("Articles", "Quantités")
		              .forEach(headerTitle -> {
		                  PdfPCell header = new PdfPCell();
		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		                 
		                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
		                  header.setBorderWidth(2);
		                  header.setPhrase(new Phrase(headerTitle, headFont));
		                  table.addCell(header);
		              });
		            
		            for (FicheStock customer : customers) {
		              PdfPCell idCell = new PdfPCell(new Phrase(customer.getMateriel().getLibelle()));
		              idCell.setPaddingLeft(2);
		              
		              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(idCell);
		 
		                PdfPCell firstNameCell = new PdfPCell(new Phrase(Integer.toString(customer.getQuantite())));
		                System.out.println(customer.getQuantite());
		                firstNameCell.setPaddingLeft(4);
		                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(firstNameCell);
		 
//		                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(customer.getMateriel().getLibelle())));
//		                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		                lastNameCell.setPaddingRight(4);
//		                table.addCell(lastNameCell);
		            }
		            document.add(table);
		            
		            document.close();
		        }catch(DocumentException e) {
//		          logger.error(e.toString());
		        }
		        
		    return new ByteArrayInputStream(out.toByteArray());

//		    Document document = new Document();
//		        ByteArrayOutputStream out = new ByteArrayOutputStream();
//		        
//		        try {
//		          
//		          PdfWriter.getInstance(document, out);
//		            document.open();
//		          
//		            // Add Text to PDF file ->
//		          Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
//		          Paragraph para = new Paragraph( "Bon Sortie", font);
//		          para.setAlignment(Element.ALIGN_CENTER);
//		          document.add(para);
//		          document.add(Chunk.NEWLINE);
//		          
//		          PdfPTable table = new PdfPTable(3);
//		            Stream.of("ID", "First Name", "Last Name")
//		              .forEach(headerTitle -> {
//		                  PdfPCell header = new PdfPCell();
//		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//		                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
//		                  header.setBorderWidth(2);
//		                  header.setPhrase(new Phrase(headerTitle, headFont));
//		                  table.addCell(header);
//		              });
//		            
//		            for (FicheStock customer : customers) {
//		              PdfPCell idCell = new PdfPCell(new Phrase(customer.getId()));
//		              idCell.setPaddingLeft(4);
//		              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		                table.addCell(idCell);
//		 
//		                PdfPCell firstNameCell = new PdfPCell(new Phrase((float) customer.getQuantite()));
//		                firstNameCell.setPaddingLeft(4);
//		                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//		                table.addCell(firstNameCell);
//		 
//		                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(customer.getMateriel().getLibelle())));
//		                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		                lastNameCell.setPaddingRight(4);
//		                table.addCell(lastNameCell);
//		            }
//		            document.add(table);
//		            
//		            document.close();
//		        }catch(DocumentException e) {
//		        }
//		        
//		    return new ByteArrayInputStream(out.toByteArray());
		  }
	  
/*******************************/
	  public static ByteArrayInputStream bonEntreePDFReport(List<FicheStock> customers) {
		    Document document = new Document();
		    DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        Chunk glue = new Chunk(new VerticalPositionMark());
		        
		       Entree mv = (Entree) customers.get(0).getMouvmentDeStock(); 
		        try {
		          
		          PdfWriter.getInstance(document, out);
		            document.open();
		          
		            // Add Text to PDF file ->
		            /*******************/
		          Font font0 = FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.DARK_GRAY);
		          Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);
		          Font font1 = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLUE);
		          Paragraph para = new Paragraph( "Bon d'entrée Stock " , font0);
		          para.setAlignment(Element.ALIGN_CENTER);
		          document.add(para);
		          document.add(Chunk.NEWLINE);
		          /*******************/
		          Paragraph para1 = new Paragraph( "N° de l'entrée", font);
		          Paragraph para11 = new Paragraph(Integer.toString(mv.numero), font1);
		          para1.add(glue);
		          para1.add("Magasin");
		          para11.add(glue);
		          para11.add(mv.getUtilisateur().getMagasin().getDesignationMagasin());
		          /*******************/
		          Paragraph para2 = new Paragraph( "Référence de l'entrée",font );
		          Paragraph para22 = new Paragraph( mv.referenceMouvement, font1);
		          para2.add(glue);
		          para2.add("Date de l'entrée");
		          para22.add(glue);
		          para22.add(df.format(mv.getDateMouvement()));
		          /*******************/
		          Paragraph para3 = new Paragraph( "Nature de l'entrée",font);
		          Paragraph para33 = new Paragraph(mv.getTypeEntree(), font1);
		          para3.add(glue);
		          para3.add("Magasinier");
		          para33.add(glue);
		          para33.add(mv.getUtilisateur().getUserName());
		          /*******************/
		          Paragraph para5 = new Paragraph( "Informations sur l'entrée",font);
		          para5.setAlignment(Element.ALIGN_CENTER);
		          para.setAlignment(Element.ALIGN_CENTER); 
		          document.add(para2);
		          document.add(para22);
		          document.add(para3);
		          document.add(para33);
		          document.add(para1);
		          document.add(para11);
		          document.add(para5);
		          document.add(Chunk.NEWLINE);
		          
//		          Paragraph para4 = new Paragraph( "Date de l'entrée", font);
//		          Paragraph para44 = new Paragraph( df.format(mv.getDateMouvement()), font);
//		          para4.setAlignment(Element.ALIGN_RIGHT);
//		          para44.setAlignment(Element.ALIGN_RIGHT);
//		          document.add(para4);
//		          document.add(para44);
		          
		          /******************/
		          float[] columnWidths = {1,1};
		          PdfPTable table = new PdfPTable(columnWidths);
		          // Add PDF Table Header ->
		          
		            Stream.of("Articles", "Quantités")
		              .forEach(headerTitle -> {
		                  PdfPCell header = new PdfPCell();
		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		                 
		                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
		                  header.setBorderWidth(2);
		                  header.setPhrase(new Phrase(headerTitle, headFont));
		                  table.addCell(header);
		              });
		            
		            for (FicheStock customer : customers) {
		              PdfPCell idCell = new PdfPCell(new Phrase(customer.getMateriel().getLibelle()));
		              idCell.setPaddingLeft(2);
		              
		              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(idCell);
		 
		                PdfPCell firstNameCell = new PdfPCell(new Phrase(Integer.toString(customer.getQuantite())));
		                System.out.println(customer.getQuantite());
		                firstNameCell.setPaddingLeft(4);
		                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(firstNameCell);
		 
//		                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(customer.getMateriel().getLibelle())));
//		                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		                lastNameCell.setPaddingRight(4);
//		                table.addCell(lastNameCell);
		            }
		            document.add(table);
		            
		            document.close();
		        }catch(DocumentException e) {
//		          logger.error(e.toString());
		        }
		        
		    return new ByteArrayInputStream(out.toByteArray());
		  }
}
