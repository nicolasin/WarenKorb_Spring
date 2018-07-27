package es.wata.warenkorb.controllers;

import java.util.List;

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

import es.wata.warenkorb.entity.Rabatt;
import es.wata.warenkorb.helperClasses.ApiResponse;
import es.wata.warenkorb.services.interfaces.RabattInterfaceService;

@RestController
@RequestMapping("/api/rabatt")
public class RabattController {
	@Autowired
	RabattInterfaceService rabattServices;


	@GetMapping("/list")
	public List<Rabatt> getAllRabatte() {
		List<Rabatt> rabatt = rabattServices.getListRabatt();
		return rabatt;
	}
	
	@GetMapping("/{id}")
	public Rabatt getRabattById(@PathVariable("id")Long id) {
		Rabatt rabatt = rabattServices.getRabattByID(id);
		return rabatt;
	}

	@PostMapping("")
	public ResponseEntity<ApiResponse> addRabatt(@RequestParam("name")String name,@RequestParam("wert")double wert, @RequestParam("type")String type){
		rabattServices.addRabatt(name,wert,type);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Sucefful added Rabat", HttpStatus.OK));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteRabatt(@PathVariable("id")Long id) {
		rabattServices.deleteRabatt(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Sucefull delete", HttpStatus.OK));
	}
	
}
