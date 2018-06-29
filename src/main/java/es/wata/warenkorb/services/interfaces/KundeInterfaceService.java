package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Kunde;

public interface KundeInterfaceService {
	
	public List<Kunde> getAll();
	public Kunde getById(Long id);
	public void addProduktToKunde(Long id, Long idProdukt);
	public void removeProduktToKunde(Long id, Long idProdukt);
	public void entlerenWarenkorb(Long id);
	
}
