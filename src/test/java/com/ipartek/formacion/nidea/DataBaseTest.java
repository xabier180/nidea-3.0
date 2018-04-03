package com.ipartek.formacion.nidea;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.ipartek.formacion.nidea.model.MaterialDAO;

public class DataBaseTest {

	@Test
	public void testDriver() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			assertTrue(true);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("No existe driver para mysql, � Tienes el .JAR ?");
		}
	}

	@Test
	public void testConexion() {

		final String URL = "jdbc:mysql://localhost/spoty?user=root&password=";
		try {
			Connection con = DriverManager.getConnection(URL);
			assertTrue(con != null);

		} catch (SQLException e) {
			e.printStackTrace();
			fail("No se pudo establecer conexion " + URL);
		}

	}

	@Test
	public void testMaterailDAO() {

		MaterialDAO dao = MaterialDAO.getInstance();
		assertNotNull(dao.getAll());

	}

}
