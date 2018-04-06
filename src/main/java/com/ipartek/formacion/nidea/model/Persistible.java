package com.ipartek.formacion.nidea.model;

import java.util.ArrayList;

public interface Persistible<P> {

	/**
	 * Lista de una tabla de la base de datos ordenado por id descendente y limitado
	 * a 500
	 * 
	 * @return coleccion
	 */
	public ArrayList<P> getAll();

	/**
	 * Obtenemos el detalle de un registro
	 * 
	 * @param id
	 *            identificador
	 * @return Registro si existe, null en caso contrario
	 */
	public P getById(int id);

	/**
	 * Guardamos un registro en la BBDD <br>
	 * Si el id del pojo == -1 creamos <br>
	 * Si el id del pojo > -1 modificamos
	 * 
	 * @param pojo
	 * @return
	 */
	public boolean save(P pojo);

	/**
	 * Eliminamos un registro por su identificador
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

}
