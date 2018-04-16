package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.ejemplos.Utilidades;
import com.ipartek.formacion.nidea.pojo.Usuario;

public class UsuarioDAO implements Persistible<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instancias
	private UsuarioDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `password`, `id_rol` FROM `usuario` ORDER BY `id` DESC LIMIT 500";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Usuario u = null;
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;

		String sql = "SELECT `id`, `nombre`, `password`, `id_rol` FROM `usuario` WHERE `id`= ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					usuario = mapper(rs);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public boolean save(Usuario pojo) {
		boolean resul = false;

		// Sanear el nombre
		pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre()));

		if (pojo != null) {

			if (pojo.getId() == -1) {
				resul = crear(pojo);
			} else {
				resul = modificar(pojo);
			}

		}

		return resul;
	}

	private boolean modificar(Usuario pojo) {
		boolean resul = false;
		String sql = "UPDATE `usuario` SET `nombre`= ? , `password`= ?, `id_rol`= ? WHERE  `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setInt(3, pojo.getId_rol());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private boolean crear(Usuario pojo) {
		boolean resul = false;
		String sql = "INSERT INTO `usuario` (`nombre`, `password`, `id_rol`) VALUES ( ? , ?, ? );";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setInt(3, pojo.getId_rol());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						resul = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sql = "DELETE FROM `usuario` WHERE  `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = null;
		if (rs != null) {
			u = new Usuario();
			u.setId(rs.getInt("id"));
			u.setNombre(rs.getString("nombre"));
			u.setPassword(rs.getString("password"));
			u.setId_rol(rs.getInt("id_rol"));
		}
		return u;
	}
}
