package com.dam.pqv;

import java.util.Comparator;

public class OrdenarElectrodomesticoPorConsumoMenAMay implements Comparator<Electrodomestico>{

	@Override
	public int compare(Electrodomestico o1, Electrodomestico o2) {
		// TODO Auto-generated method stub
		return Character.compare(o1.consumoEnergetico, o2.consumoEnergetico);
	}

}
