package com.ipartek.formacion.nidea.ejemplos;

import java.io.Serializable;

public abstract class ObjetoGrafico implements Imprimible, Cloneable, Serializable {

	public ObjetoGrafico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract void dibujar();

}
