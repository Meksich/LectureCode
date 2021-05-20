package ua.lviv.iot.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.shop.enums.BraStyles;
import ua.lviv.iot.shop.enums.Collections;
import ua.lviv.iot.shop.enums.Color;
import ua.lviv.iot.shop.enums.CupsSize;
import ua.lviv.iot.shop.enums.LinningLevel;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bra extends Underwear {

	private BraStyles style;
	private CupsSize cupsSize;
	private LinningLevel liningLevel;
	private Integer numberOfHooks;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Bra(Collections collection, Color color, Integer yearOfProduction, Double price,
		         BraStyles style, CupsSize cupsSize, LinningLevel liningLevel, Integer numberOfHooks, Integer id) {
		super(collection, color, yearOfProduction, price);
		this.style = style;
		this.cupsSize = cupsSize;
		this.liningLevel = liningLevel;
		this.numberOfHooks = numberOfHooks;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Bra:\n" + super.toString() + 
				"Style = " + style + "\n" +
				"Cups size = " + cupsSize + "\n" +
				"Lining level = " + liningLevel + "\n" +
				"Number of hooks = " + numberOfHooks + "\n";
	}
}
