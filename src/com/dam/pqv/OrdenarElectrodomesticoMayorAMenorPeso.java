package com.dam.pqv;

import java.util.Comparator;

public class OrdenarElectrodomesticoMayorAMenorPeso implements Comparator<Electrodomestico>{
//-1 + 0 + 1
	@Override
	public int compare(Electrodomestico o1, Electrodomestico o2) {
		// TODO Auto-generated method stub
		if (o1.peso > o2.peso) {
			return -1;
		} else if (o1.peso < o2.peso) {
			return 1;
		} else {
			return 0;
		}
	}

}
