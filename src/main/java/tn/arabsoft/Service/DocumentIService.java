package tn.arabsoft.Service;

import java.util.Optional;
import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.PageDocument;

public interface DocumentIService extends CrudService<Document> {

	public Optional<Document> findByName(String name);
	public PageDocument getBE(int page ,int size);
	public PageDocument getBS(String nomM ,int page , int size);
	public PageDocument getDocumentByDate(String dateD ,int page ,int size);
	public PageDocument getBSByDate(String dateD, int page, int size);
	public int getNbBE();
	public int getNbBS();
}
