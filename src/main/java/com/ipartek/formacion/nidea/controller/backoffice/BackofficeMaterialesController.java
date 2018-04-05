package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class BackofficeMaterialesController
 */
@WebServlet("/backoffice/materiales")
public class BackofficeMaterialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;
	private MaterialDAO dao;
	private Alert alert;

	// Parametros comunes
	private String search; // Buscador por nombre de material
	private int op; // Operacion a realizar

	// Parametros del material
	private int id;
	private String nombre;
	private float precio;

	/**
	 * Se ejecuta solo la primera vez que llaman al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = MaterialDAO.getInstance();
	}

	/**
	 * Se ejecuta cuando paramos el servidor de aplicaciones
	 */
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de ejecutar doGET o doPOST");
		super.service(request, response);
		System.out.println("Despues de ejecutar doGET o doPOST");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Unimos las peticiones que hacemos en doGET y doPOST
	 * 
	 * @param request
	 * @param response
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			recogerParametros(request);

			switch (op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_BUSQUEDA:
				buscar(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;

			default:
				listar(request);
				break;
			}

			// String search = request.getParameter("search");
			// System.out.println("Filtro de busqueda = " + search);

			// Enviar como atributo la lista de materiales.
			// request.setAttribute("materiales", dao.getAll());

			// dispatcher = request.getRequestDispatcher(VIEW_INDEX);

		} catch (Exception e) {

			alert = new Alert();
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher(VIEW_INDEX);

		} finally {

			request.setAttribute("alert", alert);
			dispatcher.forward(request, response);

		}

	}

	private void guardar(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void mostrarFormulario(HttpServletRequest request) {
		Material material = new Material();
		if (id > -1) {
			// TODO recuperar de la BBDD que es un material que existe
			alert = new Alert("Mostramos Detalle id:" + id, Alert.TIPO_WARNING);

		} else {
			alert = new Alert("Nuevo Producto", Alert.TIPO_WARNING);
		}
		request.setAttribute("material", material);
		request.setAttribute("id_material", id);
		// request.setAttribute("nombre_material", nombre);
		// request.setAttribute("precio_material", precio);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void listar(HttpServletRequest request) {
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	/**
	 * Recogemos todos los parametros enviados
	 * 
	 * @param request
	 */
	private void recogerParametros(HttpServletRequest request) {

		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		}

		if (request.getParameter("precio") != null) {
			precio = Float.parseFloat(request.getParameter("precio"));
		}

	}

}
