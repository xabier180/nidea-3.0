package com.ipartek.formacion.nidea.ejemplos;

public abstract class Vehiculo {

	private int puertas;
	private String color;

	public Vehiculo() {
		super(); // java.lang.Object
		this.puertas = 3;
		this.color = "blanco";
		System.out.println("Instanciado Vehiculo nuevo");
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public void encenderLuces() {
		// super.arrancar();
		System.out.println("Luces encendidas");

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract void arrancar();

	protected static void dimeMatricula() {
		// Metodo tonto para probar protected
	}

	@Override
	public String toString() {
		return "Vehiculo [puertas=" + puertas + ", color=" + color + "]";
	}

}
