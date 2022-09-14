package com.perso.parking.models;

public class Parking {

	private String nom;
	private Integer nbPlacesDispo;
	private Integer nbPlaceTotal;
	private String statut;
	private String heureMaj;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNbPlacesDispo() {
		return nbPlacesDispo;
	}
	public void setNbPlacesDispo(Integer nbPlacesDispo) {
		this.nbPlacesDispo = nbPlacesDispo;
	}
	public Integer getNbPlaceTotal() {
		return nbPlaceTotal;
	}
	public void setNbPlaceTotal(Integer nbPlaceTotal) {
		this.nbPlaceTotal = nbPlaceTotal;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getHeureMaj() {
		return heureMaj;
	}
	public void setHeureMaj(String heureMaj) {
		this.heureMaj = heureMaj;
	}
	
}
