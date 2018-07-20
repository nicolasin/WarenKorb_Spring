package es.wata.warenkorb.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.warenkorb.entity.Rabatt;
import es.wata.warenkorb.services.RabattService;
import es.wata.warenkorb.services.interfaces.RabattInterfaceService;

@RestController
@RequestMapping("/api/Rabatt")
public class RabattController {

	RabattInterfaceService rabattServices = new RabattService();

	public List<Rabatt> getListRabatt(){
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("")
	public List<Rabatt> getAllRabatte() {
		return rabattServices.getListRabatt();
	}

}
