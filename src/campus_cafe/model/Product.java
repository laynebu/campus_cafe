package campus_cafe.model;

import java.math.BigDecimal;

public abstract class Product {
	private String id;
	private String name;
	private BigDecimal basePrice;
	private String type;
	
	public Product(String id, String name, BigDecimal basePrice, String type) {
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public String getType() {
		return type;
	}
}
