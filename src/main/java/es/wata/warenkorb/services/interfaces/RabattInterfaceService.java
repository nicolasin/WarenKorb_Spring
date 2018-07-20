package es.wata.warenkorb.services.interfaces;

import java.util.List;

import es.wata.warenkorb.entity.Rabatt;
import es.wata.warenkorb.exceptions.ServiceException;

public interface RabattInterfaceService {

		public List<Rabatt> getListRabatt() throws ServiceException;
}
