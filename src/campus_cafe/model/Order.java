package campus_cafe.model;

import java.math.BigDecimal;
import java.util.*;


public class Order {
private BigDecimal taxRate = BigDecimal.valueOf(.10);
private BigDecimal newPrice;
private BigDecimal subTotal;

	public String createOrder(List<Product> order, List<String> modifiers) {
		subTotal = BigDecimal.valueOf(0.00);
		StringBuilder sb = new StringBuilder();
		sb.append("CAMPUS CAFE ORDER RECEIPT\n");
		sb.append("Q - ID -- Name (Size): Price\n");
		for (int i = 0; i < order.size(); i++ ) {
			String mods = modifiers.get(i);
			String[] modsList = mods.split(" ");
			Product item = order.get(i);
			newPrice = item.getBasePrice();
			String mod = null;
			if (modsList[0].equals("S") || modsList[0].equals("M") || modsList[0].equals("L")) {
				 if (modsList[0].equals("M")) {
					 newPrice = newPrice.add(BeverageSize.MEDIUM.getSurcharge());
					 mod = modsList[0];
				 }
				 else if(modsList[0].equals("L")) {
					 newPrice = newPrice.add(BeverageSize.LARGE.getSurcharge());
					 mod = modsList[0];
				 }
				 else {
					 newPrice = newPrice.add(BeverageSize.SMALL.getSurcharge());
					 mod = modsList[0];
				 }
				 
			}
			if ((item.getType().equals("Food"))) {
			if (modsList[2].equals("XCH") || modsList[2].equals("GF") || modsList[2].equals("BOTH")) {
				 if (modsList[2].equals("XCH")) {
					 newPrice = newPrice.add(FoodModifications.XCH.getSurcharge());
					 mod = modsList[2];
				 }
				 else if(modsList[2].equals("GF")) {
					 newPrice = newPrice.add(FoodModifications.GF.getSurcharge());
					 mod = modsList[2];
				 }
				 else if(modsList[2].equals("BOTH")) {
					 newPrice = newPrice.add(FoodModifications.XCH.getSurcharge());
					 newPrice = newPrice.add(FoodModifications.GF.getSurcharge());
					 mod = modsList[2];
				 }
				 else {
					
				 }
				 
			}
			}
			if(Integer.valueOf(modsList[1]) > 1) {
					newPrice = newPrice.multiply(BigDecimal.valueOf(Integer.valueOf(modsList[1])));
				} 
			sb.append(
				    String.format("%s - %s -- %s%s: $%.2f%n",
				    	modsList[1],
				        item.getId(),
				        item.getName(),
				        (modsList[0] == null || modsList[0].isBlank()) ? "" : " (" + mod + ")",	
				        newPrice
				    )
				);
				subTotal = subTotal.add(newPrice);
			}
			BigDecimal taxAmount = subTotal.multiply(taxRate);
			BigDecimal finalTotal = subTotal.add(taxAmount);
			sb.append("Sub Total: " + String.format("%.2f", subTotal) + "\n");
			sb.append("Tax: " + String.format("%.2f", taxAmount) + "\n");
			sb.append("Total: " + String.format("%.2f", finalTotal));
			return sb.toString();
			}
			
		}
	

