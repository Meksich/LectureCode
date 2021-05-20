package ua.lviv.iot.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.shop.enums.Collections;
import ua.lviv.iot.shop.enums.Color;
import ua.lviv.iot.shop.enums.Fabrics;
import ua.lviv.iot.shop.enums.PantsSize;
import ua.lviv.iot.shop.enums.PantsStyles;

@Data
@NoArgsConstructor
public class Pants extends Underwear {

	private PantsStyles style;
	private PantsSize size;
	private Double waistCircumference;
	private Fabrics fabrics;
	public Pants(Collections collection, Color color, Integer yearOfProduction, Double price, 
			     PantsStyles style, PantsSize size, Double waistCircumference, Fabrics fabrics) {
		super(collection, color, yearOfProduction, price);
		this.style = style;
		this.size = size;
		this.waistCircumference = waistCircumference;
		this.fabrics = fabrics;
	}
	
	@Override
	public String toString() {
		return "Pants:\n" + super.toString() + 
				"Style = " + style + "\n" +
				"Size = " + size + "\n" +
				"Waist circumference = " + waistCircumference + "\n" +
				"Fabrics = " + fabrics + "\n";
	}
}
