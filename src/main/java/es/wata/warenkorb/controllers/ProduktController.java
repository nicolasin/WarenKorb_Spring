package es.wata.warenkorb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.services.interfaces.ProduktServiceInterface;

@RestController
@RequestMapping("/api/produkt")
public class ProduktController {
	
	@Autowired
	private ProduktServiceInterface produktServ;
	@GetMapping("/list")
	public List<Produkt> produkteAnzeigen(){
		return  produktServ.getListProdukt();
	}
	@GetMapping("/{id}")
	public Produkt produkteById(@PathVariable Long id) {
		return produktServ.getProduktById(id);
	}
	@GetMapping("/produktGruppe")
	public List<Produktgruppe> produktgrupeAll(){
		return produktServ.getAllGroups();
	}
	@GetMapping("/produktGruppe/{id}")
	public List<Produktgruppe> produktgrupeByID(@PathVariable Long id){
		return produktServ.getAllGroups();
	}
}
