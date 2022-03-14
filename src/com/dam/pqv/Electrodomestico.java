package com.dam.pqv;

public class Electrodomestico {

	protected double precioBase = 100; // €
	protected String color = "blanco"; // blanco - negro - rojo - azul - gris
	protected double peso = 5; // kg
	protected char consumoEnergetico = 'F';	// A -> F
	
	
	public Electrodomestico () {
	}
	
	public Electrodomestico (double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
	}
	
	public Electrodomestico (double precioBase, String color, double peso, char consumoEnergetico) {
		this.precioBase = precioBase;
		this.color = color;
		this.peso = peso;
		this.consumoEnergetico = consumoEnergetico;
		
		comprobarConsumo(consumoEnergetico);
		comprobarColor(color);
	}
	
	
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
		comprobarColor(color);
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
		comprobarConsumo(consumoEnergetico);
	}
	
	
	private boolean comprobarConsumo (char consumoEnergetico) {
		if (consumoEnergetico == 'A' || consumoEnergetico == 'B' || consumoEnergetico == 'C' || consumoEnergetico == 'D' || consumoEnergetico == 'E' || consumoEnergetico == 'F') {
			return true;
		} else {
			System.out.println("Tipo de consumo no válido, se establece el predeterminado");
			this.consumoEnergetico = 'F';
			return false;
		}
	}
	
	private boolean comprobarColor(String color) {
		if (color == "blanco" || color == "negro" || color == "rojo" || color == "azul" || color == "gris") {
			return true;
		} else if (color == "BLANCO") { 
			this.color = "blanco";
			return true;
		} else if (color == "NEGRO") { 
			this.color = "negro";
			return true;
		} else if (color == "ROJO") { 
			this.color = "rojo";
			return true;
		} else if (color == "AZUL") { 
			this.color = "azul";
			return true;
		} else if (color == "GRIS") { 
			this.color = "gris";
			return true;
		} else {
			System.out.println("Tipo de color no válido, se establece el predeterminado");
			this.color = "blanco";
			return false;
		}
	}
	
	public double precioFinal () {
		double precio = this.precioBase;
		
		if (this.consumoEnergetico == 'A') {
			precio += 100;
		} else if (this.consumoEnergetico == 'B') {
			precio += 80;
		} else if (this.consumoEnergetico == 'C') {
			precio += 60;
		} else if (this.consumoEnergetico == 'D') {
			precio += 50;
		} else if (this.consumoEnergetico == 'E') {
			precio += 30;
		} else {
			precio += 10;
		}
		
		if (this.peso <= 19) {
			precio += 10;
		} else if (this.peso >= 20 && this.peso <= 49) {
			precio += 50;
		} else if (this.peso >= 50 && this.peso <= 79) {
			precio += 80;
		} else {
			precio += 100;
		}
		
		return precio;
	}
	
	@Override
	public String toString() {
		return ("Electrodomestico // Precio base: " + this.precioBase + " // Color: " + this.color + " // Peso: " + this.peso + " // Consumo energetico: " + this.consumoEnergetico + " // Precio final: " + this.precioFinal());
	}
}
