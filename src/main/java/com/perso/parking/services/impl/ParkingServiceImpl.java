package com.perso.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perso.parking.dao.ParkingAPIDAO;
import com.perso.parking.dao.entity.RecordEntity;
import com.perso.parking.dao.entity.ReponseParkingAPIEntity;
import com.perso.parking.models.Parking;
import com.perso.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	public ParkingAPIDAO parkingAPIDAO;
	
	@Override
	public List<Parking> getListeParkings() {

		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
		
		//Comme ce qui est retourné est une reponseEntity, il faut transformer ça 
		return transformEntityToModel(reponse);
	}

	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		for(RecordEntity record : reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatut(getLibelleStatut(record));
			parking.setNbPlacesDispo(record.getFields().getGrpDisponible());
			parking.setNbPlaceTotal(record.getFields().getGrpExploitation());
			parking.setHeureMaj(getHeureMaj(record));			
			resultat.add(parking);
		}
		
		return resultat;
	}

	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
	}

	private String getLibelleStatut(RecordEntity record) {
		
		switch(record.getFields().getGrpStatut()) {
			case "1" : {
				return "FERME";
			}
			case "2" : {
				return "ABONNES";
			}
			case "5" :{
				return "OUVERT";
			}
		}
		return "Données non disponibles";
			
		//Autre façon de faire
		/*Map<String, String> libelles = new HashMap<>();
		libelles.put("1", "FERME");
		libelles.put("2", "ABONNES");
		libelles.put("5", "OUVERT");
		
		return libelles.getOrDefault(record.getFields().getGrpStatut(), "Données non disponibles");*/
	}
}
