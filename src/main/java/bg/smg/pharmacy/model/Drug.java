package bg.smg.pharmacy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "drugs")
public class Drug {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "description")
	private String description;

	@Column(name = "prescription_required")
	private String prescription_required;

	@Column(name = "standard_dosage")
	private String standard_dosage;

	@Column(name = "stock_quantity")
	private int stockQuantity = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrescription_required() {
		return prescription_required;
	}

	public void setPrescription_required(String prescription_required) {
		this.prescription_required = prescription_required;
	}

	public String getStandard_dosage() {
		return standard_dosage;
	}

	public void setStandard_dosage(String standard_dosage) {
		this.standard_dosage = standard_dosage;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
