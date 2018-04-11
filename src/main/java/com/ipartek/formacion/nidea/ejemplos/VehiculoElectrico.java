package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {

	private float potencia; // kW

	public VehiculoElectrico() {
		super();
		this.potencia = 0;
		System.out.println("Instanciado VehiculoElectrico");

	}

	public VehiculoElectrico(float potencia) {

		// Cambiar super() por this() para sobrecargar el anterior constructor
		// y no el primero
		this();
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {
		Vehiculo.dimeMatricula();
		System.out.println("Pulsar boton encendido");

	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString() + "VehiculoElectrico [potencia=" + potencia + "]";
	}

}
