package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mesa m = new Mesa();

		// recoger parametros *** SIEMPRE String ***
		String sPatas = request.getParameter("patas");

		// Si parametros no son NULL recoger y crear mesa a medida
		if (sPatas != null) {

			int patas = Integer.parseInt(sPatas);
			m.setNumeroPatas(patas);

			String sDimnesion = request.getParameter("dimension");
			int dimension = Integer.parseInt(sDimnesion);
			m.setDimension(dimension);

			String sCustom = request.getParameter("custom");
			if (sCustom == null) {
				m.setCustom(false);
			} else { // viene 'on'
				m.setCustom(true);
			}

			String sMaterial = request.getParameter("material");
			int material = Integer.parseInt(sMaterial);
			m.setMaterial(material);

		}

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);
		request.setAttribute("materiales", Mesa.MATERIALES_LISTA);
		request.setAttribute("materialesCodigo", Mesa.MATERIALES_LISTA_CODIGO);

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
