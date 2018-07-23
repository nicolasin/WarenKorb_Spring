package es.wata.warenkorb.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.wata.warenkorb.entity.Produkt;
import es.wata.warenkorb.entity.Produktgruppe;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.ProduktServiceInterface;

@RestController
@RequestMapping("/api/produkt")
public class ProduktController {
	
	@Autowired
	private ProduktServiceInterface produktServ;
	//PRODUKT
	@PostMapping("")
	public ResponseEntity<ApiResponse> addProdukt(@RequestParam("name")String name, @RequestParam("preis")double preis){
		produktServ.addProdukt(name,preis);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Sucefull created", HttpStatus.CREATED));
	}
	
	@GetMapping("/list")
	public List<Produkt> produkteAnzeigen(){
		return  produktServ.getListProdukt();
	}
	@GetMapping("/{id}")
	public Produkt produkteById(@PathVariable Long id) {
		return produktServ.getProduktById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteProduktById(@PathVariable Long id) {
		produktServ.deleteProduktById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Delete Sucefully", HttpStatus.OK));
	}
	
	//CATEGORIES
	@GetMapping("/gruppe")
	public List<Produktgruppe> produktgrupeAll(){
		return produktServ.getAllCategorie();
	}
	@GetMapping("/gruppe/{id}")
	public List<Produktgruppe> produktgrupeByID(@PathVariable Long id){
		return produktServ.getAllCategorie();
	}
	@DeleteMapping("/gruppe/{id}")
	public ResponseEntity<ApiResponse> deleteGruppeById(@PathVariable Long id){
		produktServ.removeCategorie(id);
		return ResponseEntity.ok().body(new ApiResponse("Suceffull delete", HttpStatus.OK));
	}
	
	@PostMapping("/gruppe")
	public ResponseEntity<ApiResponse> addGruppe(@RequestParam("name")String name){
		produktServ.addCategorie(name);
		return ResponseEntity.ok().body(new ApiResponse("Suceffull create", HttpStatus.CREATED));
	}
	
	
	
}
