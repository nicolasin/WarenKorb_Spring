package es.wata.warenkorb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.wata.warenkorb.entity.Kunde;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
	Kunde findByName(String name);
}
