package tn.arabsoft.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Document")
public class Document {

	public Document() {
		super();
	}

	public Document(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;
	

	@Column(name="dateDc")
	public Date dateDc = new Date();

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte", length = 3000)
	private byte[] picByte;
	
	@ManyToOne
	@JoinColumn(name="inventaire")
	private Inventaire inventaire;

	public String getName() {
		return name;
	}
	
	

	public Date getDateDc() {
		return dateDc;
	}

	public void setDateDc(Date dateDc) {
		this.dateDc = dateDc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document(Long id, String name, String type, Date dateDc, byte[] picByte) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.dateDc = dateDc;
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", type=" + type + ", dateDc=" + dateDc + ", picByte="
				+ Arrays.toString(picByte) + "]";
	}

	
	
	
	
}
