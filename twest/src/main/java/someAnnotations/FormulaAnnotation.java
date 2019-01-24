package someAnnotations;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

@Entity
public class FormulaAnnotation {
	@Id
	int id;
	
	String name;
	int amount;
	
	@Formula(value="amount / 10")
	Double discount;
	
	@Formula(value="amount - discount")
	Double netAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	
	

}
