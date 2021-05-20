package ua.lviv.iot.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.shop.enums.Collections;
import ua.lviv.iot.shop.enums.Color;

@Data
@NoArgsConstructor
public class Underwear {

	protected Collections collection;
	protected Color color;
	protected Integer yearOfProduction;
	protected Double price;
	public Underwear(Collections collection, Color color, Integer yearOfProduction, Double price) {
		this.collection = collection;
		this.color = color;
		this.yearOfProduction = yearOfProduction;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Collection = " + collection + "\n" +
				"Color = " + color + "\n" +
				"Year of production = " + yearOfProduction +"\n" +
				"Price = " + price + "\n";
	}
}
