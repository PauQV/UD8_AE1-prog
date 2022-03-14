package com.dam.pqv;

public class Television extends Electrodomestico {

	private double pulgadas = 20;
	private Boolean smartTV = false;
	
	public Television() {
	}
	public Television (double precioBase, double peso) {
		super(precioBase, peso);
	}
	public Television (double precioBase, String color, double peso, char consumoEnergetico, double pulgadas, Boolean smartTV) {
		super (precioBase, color, peso, consumoEnergetico);
		this.pulgadas = pulgadas;
		this.smartTV = smartTV;
	}
	
	public double getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}
	public Boolean getSmartTV() {
		return smartTV;
	}
	public void setSmartTv(Boolean smartTV) {
		this.smartTV = smartTV;
	}
	
	@Override
	public double precioFinal () {
		double precio = super.precioFinal();
		
		if (this.pulgadas > 40) {
			precio += (precio*30/100);
		}
		
		if (this.smartTV == true) {
			precio += 50;
		}
		
		return precio;
	}
	
	@Override
	public String toString() {
		return ("Televisión // Precio base: " + this.precioBase + " // Color: " + this.color + " // Peso: " + this.peso + " // Consumo energetico: " + this.consumoEnergetico + " // Pulgadas: " + this.pulgadas + " // SmartTV? " + this.smartTV + " // Precio final: " + this.precioFinal());
	}
}
