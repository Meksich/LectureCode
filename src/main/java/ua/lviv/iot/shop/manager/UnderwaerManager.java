package ua.lviv.iot.shop.manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.shop.enums.Collections;
import ua.lviv.iot.shop.enums.SortOrder;
import ua.lviv.iot.shop.models.Underwear;

public class UnderwaerManager {

	public List<Underwear> underwear = new ArrayList<>();
	public void addUnderwear(Underwear underwear) {
		this.underwear.add(underwear);
	}
	public List<Underwear> searchByCollection(Collections collection) {
		return underwear.stream()
				.filter(underw -> underw.getCollection().equals(collection))
				.collect(Collectors.toList());
	}
	
	public List<Underwear> searchByYear(Integer year){
		
		return underwear.stream()
				.filter(underw -> underw.getYearOfProduction().equals(year))
				.collect(Collectors.toList());
		
	}
	public List<Underwear> sortByPrice(SortOrder order) {
		if (order == SortOrder.ASC) {
			return underwear.stream()
					 		.sorted(Comparator.comparing(Underwear::getPrice))
					 		.collect(Collectors.toList());
		}
		return underwear.stream()
					 .sorted(Comparator.comparing(Underwear::getPrice).reversed())
					 .collect(Collectors.toList());
	}
	public void printUnderwear(List<Underwear> underwear) {
		underwear.forEach(System.out::println);
	}
}
