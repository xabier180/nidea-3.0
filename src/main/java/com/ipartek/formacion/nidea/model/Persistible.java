package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
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

	/**
	 * Nos mapea un resultado de la BBDD a un Pojo
	 * 
	 * @param rs
	 *            ResultSet 1 registro de la consulta
	 * @return Pojo con los valores del ResultSet o null si no hay valores
	 */
	public P mapper(ResultSet rs) throws SQLException;

}
