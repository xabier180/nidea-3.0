package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {

	private float potencia; // kW

	public VehiculoElectrico() {
		super();
		this.potencia = 0;
		System.out.println("Instanciado VehiculoElectrico");

	}

	@Override
	public void arrancar() {
		// super.arrancar();
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
