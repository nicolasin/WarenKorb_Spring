package es.wata.warenkorb.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarenkorbToJSON {
	private Header header = new Header();
	private List<Detail> detail;
	private Footer footer;

	public WarenkorbToJSON(Kunde kunde) {
		detail = new ArrayList<Detail>();
		addDetailsToWarenkorb(kunde);
		footer = new Footer();
		addFooterToWarenKorb(kunde);
	}

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	private void addFooterToWarenKorb(Kunde kunde) {

		addRabatNamesToFooter(kunde);
		calculateTotalPreis(kunde);

	}

	private void calculateTotalPreis(Kunde kunde) {
		double totalPreis;
		if (detail.isEmpty()) {
			totalPreis = 0;
		}else {
			totalPreis = detail.stream().mapToDouble(x -> x.anzahl * x.preisNachRabatt).sum();
			footer.gesamt = totalPreis;
			footer.gesamt -= kunde.getRabatt().rabattAnwenden(totalPreis);
			footer.gesamt -= kunde.getGruppe().getRabatt().rabattAnwenden(totalPreis);
			footer.gesamt = Math.max(0, footer.gesamt);
		}

	}

	private void addRabatNamesToFooter(Kunde kunde) {
		if (kunde.getRabatt() != null) {
			footer.rabatt.add(kunde.getRabatt().toString());
		}
		if (kunde.getGruppe() != null && kunde.getGruppe().getRabatt() != null) {
			footer.rabatt.add(kunde.getGruppe().getRabatt().toString());
		}

	}

	private void addDetailsToWarenkorb(Kunde kunde) {
		if (!kunde.getWarenkorb().isEmpty()) {
			for (Produkt produkt : kunde.getWarenkorb()) {
				if (detail.stream().filter(x -> x.name.equals(produkt.getName())).count() == 0) {
					Detail dt = new Detail();
					dt.name = produkt.getName();
					dt.anzahl = kunde.getWarenkorb().stream().filter(x -> x.equals(produkt)).count();
					dt.preis = produkt.getPreis();
					addRabatt(dt.rabatt, produkt);
					dt.preisNachRabatt = preisNachRabat(produkt);
					detail.add(dt);

				}

			}
		}
	}

	private double preisNachRabat(Produkt produkt) {

		double acum = 0;
		if (produkt.getRabat() != null) {

			acum += produkt.getRabat().rabattAnwenden(produkt.getPreis());
		}

		for (Produktgruppe grupp : produkt.getGruppe()) {
			if (grupp.getRabatt() != null) {
				acum += grupp.getRabatt().rabattAnwenden(produkt.getPreis());
			}
		}
		return Math.max(0, produkt.getPreis() - acum);
	}

	private void addRabatt(List<String> lista, Produkt produkt) {

		if (produkt.getRabat() != null) {

			lista.add(produkt.getRabat().getName());
		}

		for (Produktgruppe grupp : produkt.getGruppe()) {
			if (grupp.getRabatt() != null) {
				lista.add(grupp.getRabatt().getName());
			}
		}
	}

	public String getHeader() {
		return header.datum.toString();
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public List<Detail> getDetails() {
		return detail;
	}

	public void setDetails(List<Detail> details) {
		this.detail = details;
	}

}

class Header {
	public String datum;

	public Header() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		datum = LocalDate.now().format(formatter).toString();
	}
}

class Detail {
	public Long anzahl;
	public String name;
	public double preis;
	public List<String> rabatt = new ArrayList<String>();
	public double preisNachRabatt;

}

class Footer {
	public Set<String> rabatt = new HashSet<String>();
	public double gesamt;
}
