package tn.arabsoft.Dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.Document;


public interface ImageRepository extends JpaRepository<Document, Long> {
	Optional<Document> findByName(String name);
	
	@Query("select d from Document d where SUBSTR(d.name,1,2) = 'BE' ORDER BY d.dateDc DESC")
	public Page<Document> getBE(Pageable pageable);
	
//	and SUBSTR(d.name,9,10) = :nomM
	@Query("select d from Document d where SUBSTR(d.name,1,2) = 'BS' and SUBSTR(d.name,9,2) = :nomM ORDER BY d.dateDc DESC")
	public Page<Document> getBS(@Param("nomM")String nomM,Pageable pageable );
	
	@Query("select count(*) from Document d where SUBSTR(d.name,1,2) = 'BE'")
	public int getNbBE();
	
	@Query("select count(*) from Document d where SUBSTR(d.name,1,2) = 'BS'")
	public int getNbBS();
	
	@Query("select d from Document d where DATE_FORMAT(dateDc,'%Y-%m-%d') = :dateD and SUBSTR(d.name,1,2) = 'BE' ORDER BY d.dateDc DESC")
	public Page<Document> getDocumentByDate(@Param("dateD") String dateD ,Pageable pageable);
	
	@Query("select d from Document d where DATE_FORMAT(dateDc,'%Y-%m-%d') = :dateD and"
			+ " SUBSTR(d.name,1,2) = 'BS' and"
			+ " SUBSTR(d.name,9,2) = :nomM  "
			+ "ORDER BY d.dateDc DESC")
	public Page<Document> getBSByDate(@Param("dateD") String dateD ,Pageable pageable);
	
}