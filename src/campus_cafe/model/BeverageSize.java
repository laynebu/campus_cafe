package campus_cafe.model;

import java.math.BigDecimal;

public enum BeverageSize {
	SMALL(BigDecimal.valueOf(0.00)),
	MEDIUM(BigDecimal.valueOf(1.00)),
	LARGE(BigDecimal.valueOf(2.00));
	
	private final BigDecimal surcharge;
	
	BeverageSize(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}
	public BigDecimal getSurcharge() {
		return surcharge;
		
	}
}
