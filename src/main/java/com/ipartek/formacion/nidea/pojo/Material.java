package com.ipartek.formacion.nidea.pojo;

public class Material {

	private int id;
	private String nombre;
	private float precio;

	public Material() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre.trim();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
