package br.edu.ifpb.projetopwebii.model;

import br.edu.ifpb.pwebprojeto.util.TipoFeriado;

public class Calendario {

	
	private int id;
	private String title;
	private String start;
	private String end;
	private String color;
	private TipoFeriado tipo;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getStart() {
		return start;
	}
	public String getStartDiaMes() {
		return start.substring(5,11);
	}
	

	public void setStart(String start) {
		this.start = start;
	}
	
	
	public String getEnd() {
		return end;
	}
	public String getEndDiaMes() {
		return end.substring(5,11);
	}
	
	public void setEnd(String end) {
		this.end = end;
	}

	public TipoFeriado getTipo() {
		return tipo;
	}

	public void setTipo(TipoFeriado tipo) {
		this.tipo = tipo;
	}

	
	
	
}
