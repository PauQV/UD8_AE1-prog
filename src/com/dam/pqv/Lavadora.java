package com.dam.pqv;

public class Lavadora extends Electrodomestico {

	private double carga = 5; // kg

	public Lavadora () {
	}
	
	public Lavadora (double precioBase, double peso) {
		super(precioBase, peso);
	}
	
	public Lavadora (double precioBase, String color, double peso, char consumoEnergetico, double carga) {
		super (precioBase, color, peso, consumoEnergetico);
		this.carga = carga;
	}
	
	
	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	@Override
	public double precioFinal () {
		double precio = super.precioFinal();
		
		if (this.carga > 30) {
			precio += 50;
		}
		
		return precio;
	}
	
	@Override
	public String toString() {
		return ("Lavadora // Precio base: " + this.precioBase + " // Color: " + this.color + " // Peso: " + this.peso + " // Consumo energetico: " + this.consumoEnergetico + " // Carga: " + this.carga + " // Precio final: " + this.precioFinal());
	}
}
