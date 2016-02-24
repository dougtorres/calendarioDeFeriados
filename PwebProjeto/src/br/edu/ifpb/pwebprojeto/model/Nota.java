package br.edu.ifpb.pwebprojeto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String date;
	private String color = "#a1a1a1";
	private String title;
	
	public Nota (String descricao, String data){

		this.date = data;
		this.title = descricao;
		
	}
	
	public Nota(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String data) {

		this.date = date;
	}

	public String getText() {
		return title;
	}

	public void setText(String descricao) {
		this.title = descricao;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	

}
