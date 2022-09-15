package com.perso.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//On ignore les autres champs avec l'annnotation (sinon java lève une erreur)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldsEntity {

	@JsonProperty(value = "idobj")
	private String idObj;
	
	@JsonProperty(value = "grp_nom")
	private String grpNom;
	
	@JsonProperty(value = "grp_exploitation")
	private int grpExploitation;
	
	@JsonProperty(value = "grp_disponible")
	private int grpDisponible;
	
	@JsonProperty(value = "grp_statut")
	private String grpStatut;
	
	@JsonProperty(value = "grp_horodatage")
	private String grpHorodatage;	
	
	public String getIdObj() {
		return idObj;
	}

	public void setIdObj(String idObj) {
		this.idObj = idObj;
	}

	public String getGrpNom() {
		return grpNom;
	}

	public void setGrpNom(String grpNom) {
		this.grpNom = grpNom;
	}

	public int getGrpExploitation() {
		return grpExploitation;
	}

	public void setGrpExploitation(int grpExploitation) {
		this.grpExploitation = grpExploitation;
	}

	public int getGrpDisponible() {
		return grpDisponible;
	}

	public void setGrpDisponible(int grpDisponible) {
		this.grpDisponible = grpDisponible;
	}

	public String getGrpStatut() {
		return grpStatut;
	}

	public void setGrpStatut(String grpStatut) {
		this.grpStatut = grpStatut;
	}

	public String getGrpHorodatage() {
		return grpHorodatage;
	}

	public void setGrpHorodatage(String grpHorodatage) {
		this.grpHorodatage = grpHorodatage;
	}
	
}
