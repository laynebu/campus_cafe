package campus_cafe.model;

import java.math.BigDecimal;

public enum FoodModifications {
	XCH(BigDecimal.valueOf(0.50)),
	GF(BigDecimal.valueOf(0.50));

	
	private final BigDecimal surcharge;
	
	FoodModifications(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}
	public BigDecimal getSurcharge() {
		return surcharge;
		
	}
}
