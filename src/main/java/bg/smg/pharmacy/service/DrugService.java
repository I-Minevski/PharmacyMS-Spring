package bg.smg.pharmacy.service;

import java.util.List;

import bg.smg.pharmacy.model.Drug;
import org.springframework.data.domain.Page;

public interface DrugService {
	List<Drug> getAllDrugs();
	void saveDrug(Drug drug);
	Drug getDrugById(long id);
	void deleteDrugById(long id);
	void orderDrug(long id, int quantity);
	Boolean sellDrug(long id, int quantity);
	Page<Drug> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<Drug> searchDrugs(String name, String description, Double minPrice, Double maxPrice);
}
