package ua.lviv.iot.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.shop.enums.Collections;
import ua.lviv.iot.shop.enums.Color;
import ua.lviv.iot.shop.enums.LingerieStyles;
import ua.lviv.iot.shop.enums.PantsSize;

@Data
@NoArgsConstructor
public class Lingerie extends Underwear {
	private LingerieStyles style;
	private PantsSize size;
	private Boolean sleeveless;
	public Lingerie(Collections collection, Color color, Integer yearOfProduction,
					Double price, LingerieStyles style, PantsSize size, Boolean sleeveless) {
	super(collection, color, yearOfProduction, price);
	this.style = style;
	this.size = size;
	this.sleeveless = sleeveless;
	}
	@Override
	public String toString() { return "Lingerie:\n" + super.toString() +
				"Style = " + style + "\n" +
				"Size = " + size + "\n" +
				"Sleeveless = " + sleeveless + "\n";
	}
}
