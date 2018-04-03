package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;
import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
@WebServlet("/generar-mesa")
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mesa m = new Mesa();
		MaterialDAO dao = MaterialDAO.getInstance();

		// recoger parametros *** SIEMPRE String ***
		String sPatas = request.getParameter("patas");

		// Si parametros no son NULL recoger y crear mesa a medida
		if (sPatas != null) {

			int patas = Integer.parseInt(sPatas);
			try {
				m.setNumeroPatas(patas);
			} catch (Exception e) {

				try {
					m.setNumeroPatas(1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				request.setAttribute("alert", new Alert(e.getMessage(), Alert.TIPO_WARNING));

			}

			String sDimnesion = request.getParameter("dimension");
			int dimension = Integer.parseInt(sDimnesion);
			m.setDimension(dimension);

			String sCustom = request.getParameter("custom");
			if (sCustom == null) {
				m.setCustom(false);
			} else { // viene 'on'
				m.setCustom(true);

				// color
				String color = request.getParameter("color");
				m.setColor(color);
			}

			// material
			String sMateriaPrecio = request.getParameter("materialPrecio");
			Material material = new Material();
			material.setPrecio(Float.parseFloat(sMateriaPrecio));
			m.setMaterial(material);

		}

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);
		request.setAttribute("materiales", dao.getAll());

		// ir a la JSP
		request.getRequestDispatcher("mesa.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
