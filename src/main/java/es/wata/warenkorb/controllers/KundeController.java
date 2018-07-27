package es.wata.warenkorb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.entity.WarenkorbToJSON;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.KundeInterfaceService;

@RestController
@RequestMapping("/api/kunde")
public class KundeController {

	@Autowired
	KundeInterfaceService serviceKunde;

	@GetMapping("/list")
	public List<Kunde> showKunde() {
		List<Kunde> kunden = serviceKunde.getAll();
		return kunden;
	}

	@PostMapping("")
	public void savekunde(@RequestBody Kunde kunde) {
		serviceKunde.save(kunde);
		
	}

	@GetMapping("/{id}")
	public Kunde showKundeById(@PathVariable Long id) {
		Kunde kunde = null;
		kunde = serviceKunde.getById(id);
		return kunde;
	}

	@PostMapping("/addKunde")
	public ResponseEntity<ApiResponse> addNeuKunde(@RequestParam("name") String name, @RequestParam("nick") String nick,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		serviceKunde.addNeuKunde(name, nick, password, email);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Succesfull to create Kunde", HttpStatus.CREATED));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> removeKunde(@PathVariable("id") Long idKunde) {
		serviceKunde.deleteKunde(idKunde);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Succesfull to Delete Kunde", HttpStatus.OK));

	}

	@GetMapping("/{id}/warenkorb")
	public WarenkorbToJSON getWarenKorb(@PathVariable("id") Long id) {
		Kunde kunde = serviceKunde.getById(id);
		WarenkorbToJSON wtj = new WarenkorbToJSON(kunde);
		return wtj;
	}

	@PutMapping("/{id}/warenkorb/{idProdukt}")
	public ResponseEntity<ApiResponse> addProduktToWarenKorb(@PathVariable("id") Long id,
			@PathVariable("idProdukt") Long idProdukt) {
		serviceKunde.addProduktToKunde(id, idProdukt);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Succesfull to insert produkt in warenkorb", HttpStatus.OK));
	}

	@DeleteMapping("/{id}/warenkorb/{idProdukt}")
	public ResponseEntity<ApiResponse> removeProduktToWarenKorb(@PathVariable("id") Long id,
			@PathVariable("idProdukt") Long idProdukt) {
		serviceKunde.removeProduktToKunde(id, idProdukt);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse("Succesfull remove produkt in warenkorb", HttpStatus.OK));
	}

	@DeleteMapping("/{id}/warenkorb/entleren")
	public ResponseEntity<ApiResponse> entlerenWarenKorb(@PathVariable("id") Long id) {
		serviceKunde.entlerenWarenkorb(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new ApiResponse("Succesfull to warenkorb entleren", HttpStatus.ACCEPTED));
	}
}
