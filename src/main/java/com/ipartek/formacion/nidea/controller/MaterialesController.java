package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;

/**
 * Servlet implementation class MaterialesController
 */
@WebServlet("/materiales")
public class MaterialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Enviar como atributo la lista de materiales.
			MaterialDAO dao = MaterialDAO.getInstance();
			request.setAttribute("materiales", dao.getAll());

			view = "materiales.jsp";

		} catch (Exception e) {

			e.printStackTrace();
			view = "materiales.jsp";

		} finally {

			request.getRequestDispatcher(view).forward(request, response);

		}
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
