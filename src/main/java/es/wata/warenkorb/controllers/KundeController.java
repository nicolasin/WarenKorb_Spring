package es.wata.warenkorb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.services.interfaces.KundeInterfaceService;

@RestController
@RequestMapping("/api/kunde")
public class KundeController {

	@Autowired
	KundeInterfaceService serviceKunde;

	@GetMapping("/list")
	public List<Kunde> showKunde() {
		return serviceKunde.getAll();
	}

	@GetMapping("/{id}")
	public Kunde showKundeById(@PathVariable Long id) {
		return serviceKunde.getById(id);
	}

	@GetMapping("/{id}/add/{id_produkt}")
	public void addProduktToWarenKorb(@PathVariable("id") Long id, @PathVariable("id_produkt") Long idProdukt) {
		System.out.println("ID: " + id + " , PRODUKT ID: " + idProdukt);
		serviceKunde.addProduktToKunde(id, idProdukt);
	}

	@GetMapping("/{id}/remove/{id_produkt}")
	public void removeProduktToWarenKorb(@PathVariable("id") Long id, @PathVariable("id_produkt") Long idProdukt) {
		System.out.println("ID: " + id + " , PRODUKT ID: " + idProdukt);
		serviceKunde.removeProduktToKunde(id, idProdukt);
	}
	@GetMapping("{id}/entleren")
	public void entlerenWarenKorb(@PathVariable("id") Long id) {
		serviceKunde.entlerenWarenkorb(id);
	}
}
