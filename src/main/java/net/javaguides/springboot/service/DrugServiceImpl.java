package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import net.javaguides.springboot.model.Drug;
import net.javaguides.springboot.repository.DrugRepository;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugRepository drugRepository;

	@Override
	public List<Drug> getAllDrugs() {
		return drugRepository.findAll();
	}

	@Override
	public void saveDrug(Drug drug) {
		this.drugRepository.save(drug);
	}

	@Override
	public Drug getDrugById(long id) {
		Optional<Drug> optional = drugRepository.findById(id);
		Drug drug = null;
		if (optional.isPresent()) {
			drug = optional.get();
		} else {
			throw new RuntimeException(" Drug not found for id :: " + id);
		}
		return drug;
	}

	@Override
	public void deleteDrugById(long id) {
		this.drugRepository.deleteById(id);
	}

	@Override
	public void orderDrug(long id, int quantity) {
		Drug drug = getDrugById(id);
		int newStockQuantity = drug.getStockQuantity() + quantity;
		drug.setStockQuantity(newStockQuantity);
		saveDrug(drug);
	}

	@Override
	public Boolean sellDrug(long id, int quantity) {
		Drug drug = getDrugById(id);
		int currentStockQuantity = drug.getStockQuantity();
		if (currentStockQuantity < quantity) {
			return false;
		}
		int newStockQuantity = currentStockQuantity - quantity;
		drug.setStockQuantity(newStockQuantity);
		saveDrug(drug);
		return true;
	}



	@Override
	public Page<Drug> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.drugRepository.findAll(pageable);
	}

	@Override
	public List<Drug> searchDrugs(String name, String description, Double minPrice, Double maxPrice) {
		List<Drug> allDrugs = drugRepository.findAll();
		return allDrugs.stream()
				.filter(drug -> (name == null || drug.getName().toLowerCase().contains(name.toLowerCase())))
				.filter(drug -> (description == null || drug.getDescription().toLowerCase().contains(description.toLowerCase())))
				.filter(drug -> (minPrice == null || drug.getPrice() >= minPrice))
				.filter(drug -> (maxPrice == null || drug.getPrice() <= maxPrice))
				.collect(Collectors.toList());
	}

}
