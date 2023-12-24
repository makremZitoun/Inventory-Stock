package tn.arabsoft.Rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.arabsoft.Service.DocumentIService;
import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.PageDocument;

@RestController
@RequestMapping(value="/image" )
public class ImageRest {

	@Autowired
	private DocumentIService iS ;
	
	
//	@PostMapping("/upload")
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public Document uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
     
		System.out.println("Original Image Byte Size - " + file.getBytes().length  );
		Document img = new Document(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		return  iS.save(img);
	}
	
	

	@GetMapping(path = { "/get/{imageName}" })
	public Document getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<Document> retrievedImage = iS.findByName(imageName);
		Document img = new Document(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

	@RequestMapping(value="/getBE/{page}/{size}",method=RequestMethod.GET)
	public PageDocument getBE(@PathVariable int page,@PathVariable int size) {
		
		//System.out.println(pS.findAll(page, size).toString());
		
		return iS.getBE(page, size);
	}
	
	@RequestMapping(value="/getBS/{nomM}/{page}/{size}",method=RequestMethod.GET)
	public PageDocument getBS(@PathVariable String nomM,@PathVariable int page,@PathVariable int size) {
		
		//System.out.println(pS.findAll(page, size).toString());
		
		return iS.getBS(nomM,page, size );
//		return null ;
	}
	
	@RequestMapping(value="/getBeByDate/{dateD}/{page}/{size}",method=RequestMethod.GET)
	public PageDocument getBeByDate(@PathVariable String dateD, @PathVariable int page, @PathVariable int size) {
		return iS.getDocumentByDate(dateD, page, size);
	}
	
	@RequestMapping(value="/getBsByDate/{dateD}/{page}/{size}",method=RequestMethod.GET)
	public PageDocument getBsByDate(@PathVariable String dateD, @PathVariable int page, @PathVariable int size) {
		return iS.getBSByDate(dateD, page, size);
	}
	
	
	
	@RequestMapping(value="/getNbBE",method=RequestMethod.GET)
	public int getNbBE() {
		return iS.getNbBE();
	}
	
	@RequestMapping(value="/getNbBS",method=RequestMethod.GET)
	public int getNbBS() {
		return iS.getNbBE();
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}



}
