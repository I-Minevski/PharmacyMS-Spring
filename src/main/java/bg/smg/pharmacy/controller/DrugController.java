package bg.smg.pharmacy.controller;

import java.util.List;

import bg.smg.pharmacy.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bg.smg.pharmacy.service.DrugService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DrugController {

	@Autowired
	private DrugService drugService;

	// display list of drugs
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);
	}

	@GetMapping("/showNewDrugForm")
	public String showNewDrugForm(Model model) {
		// create model attribute to bind form data
		Drug drug = new Drug();
		model.addAttribute("drug", drug);
		return "new_drug";
	}

	@PostMapping("/saveDrug")
	public String saveDrug(@ModelAttribute("drug") Drug drug) {
		// save drug to database
		drugService.saveDrug(drug);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		// get drug from the service
		Drug drug = drugService.getDrugById(id);

		// set drug as a model attribute to pre-populate the form
		model.addAttribute("drug", drug);
		return "update_drug";
	}

	@GetMapping("/deleteDrug/{id}")
	public String deleteDrug(@PathVariable (value = "id") long id) {

		// call delete drug method 
		this.drugService.deleteDrugById(id);
		return "redirect:/";
	}


	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 5;

		Page<Drug> page = drugService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Drug> listDrugs = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listDrugs", listDrugs);
		return "index";
	}

	@GetMapping("/viewStock/{id}")
	public String viewStock(@PathVariable(value = "id") long id, Model model) {
		Drug drug = drugService.getDrugById(id);
		model.addAttribute("drug", drug);
		return "manage_stock";
	}



	@PostMapping("/orderDrug/{id}")
	public String orderDrug(@PathVariable("id") long id, @RequestParam("quantity") int quantity) {
		drugService.orderDrug(id, quantity);
		return "redirect:/";
	}

	@PostMapping("/sellDrug/{id}")
	public String sellDrug(@PathVariable("id") long id, @RequestParam("quantity") int quantity, Model model, RedirectAttributes redirectAttributes) {
		Boolean success = drugService.sellDrug(id, quantity);
		if (!success) {
			redirectAttributes.addFlashAttribute("warningMessage", "Insufficient stock quantity to sell.");
			return "redirect:/viewStock/" + id;
		}
		return "redirect:/";
	}


	@GetMapping("/search")
	public String searchDrugs(@RequestParam(value = "name", required = false) String name,
							  @RequestParam(value = "description", required = false) String description,
							  @RequestParam(value = "minPrice", required = false) Double minPrice,
							  @RequestParam(value = "maxPrice", required = false) Double maxPrice,
							  Model model) {
		List<Drug> listDrugs = drugService.searchDrugs(name, description, minPrice, maxPrice);
		model.addAttribute("listDrugs", listDrugs);
		return "index";
	}




}
