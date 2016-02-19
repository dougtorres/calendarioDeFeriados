package br.edu.ifpb.projetopwebii.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifpb.pwebprojeto.util.TipoFeriado;
@Entity
public class Feriado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Date inicio;
	private Date fim;
	private String cor;
	
	@Enumerated(EnumType.STRING)
	private TipoFeriado tipo;
	private Date inicioSubstituto;
	private Date fimSubstituto;
	
	public Feriado(){}
	
	public Feriado(String titulo, String inicio, String fim, TipoFeriado tipo) throws ParseException{
		
		this.titulo = titulo;
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		this.inicio = sdf1.parse(inicio);
		this.fim = sdf1.parse(fim);
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getInicio() {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf1.format(this.inicio);
	}
	
	public String getInicioSubstituto() {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf1.format(this.inicioSubstituto);
	}
	
	public void setInicio(String inicio) throws ParseException {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		this.inicio = sdf1.parse(inicio);
	}
	
	public String getDiaMesInicio() {
		SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd"); 
		return sdf1.format(this.inicio);
	}

	public String getDiaMesFim() {
		SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd"); 
		return sdf1.format(this.fim);
	}

	public String getFim() {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf1.format(this.fim);
	}
	public String getFimSubstituto() {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf1.format(this.fimSubstituto);
	}


	public void setFim(String fim) throws ParseException {
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); 
		this.fim = sdf1.parse(fim);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoFeriado getTipo() {
		return tipo;
	}

	public void setTipo(TipoFeriado tipo) {
		this.tipo = tipo;
	}

	public void setInicioSubstituto(String inicioSubstituto) throws ParseException {
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		this.inicioSubstituto = sdf1.parse(inicioSubstituto);
	}

	public void setFimSubstituto(String fimSubstituto) throws ParseException {
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
		this.fimSubstituto = sdf1.parse(fimSubstituto);
	}
	
	public String getAnoSubstituto(){
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy"); 
		return sdf1.format(this.inicioSubstituto);
	}


	
	
	
	
	
}
