package com.dam.pqv;

import java.util.Comparator;

public class OrdenarElectrodomesticoMenorAMayorPrecio implements Comparator<Electrodomestico>{

	@Override
	public int compare(Electrodomestico o1, Electrodomestico o2) {
		// TODO Auto-generated method stub
		if (o1.precioFinal() < o2.precioFinal()) {
			return -1;
		} else if (o1.precioFinal() > o2.precioFinal()) {
			return 1;
		} else {
			return 0;
		}
	}

}
