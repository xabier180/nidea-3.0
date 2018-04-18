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

import com.ipartek.formacion.nidea.model.RolDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Rol;

/**
 * Servlet implementation class BackofficeRolController
 */
@WebServlet("/backoffice/rol")
public class BackofficeRolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "rol/index.jsp";
	private static final String VIEW_FORM = "rol/form.jsp";

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;
	private RolDAO dao;
	private Alert alert;

	// Parametros comunes
	private String search; // Buscador por nombre de rol
	private int op; // Operacion a realizar

	// Parametros del rol
	private int id;
	private String nombre;

	/**
	 * Se ejecuta solo la primera vez que llaman al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = RolDAO.getInstance();
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

			// Enviar como atributo la lista de roles.
			// request.setAttribute("roles", dao.getAll());

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
		Rol rol = new Rol();
		try {

			rol.setId(id);
			rol.setNombre(nombre);

			if (nombre != "" && nombre.length() <= 45) {
				if (dao.save(rol)) {
					alert = new Alert("Rol guardado", Alert.TIPO_PRIMARY);

				} else {
					alert = new Alert("Lo sentimos pero este rol ya existe en la base de datos", Alert.TIPO_WARNING);
				}
				request.setAttribute("rol", rol);
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
			} else {
				if (nombre == "") {
					alert = new Alert("Por favor, rellene el nombre del rol", Alert.TIPO_WARNING);
					request.setAttribute("rol", rol);
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				} else {
					if (nombre.length() > 45) {
						alert = new Alert("El rol no puede exceder de los 45 caracteres", Alert.TIPO_WARNING);
						request.setAttribute("rol", rol);
						dispatcher = request.getRequestDispatcher(VIEW_FORM);
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Rol> roles = new ArrayList<Rol>();
		roles = dao.getAll();
		request.setAttribute("roles", roles);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {

		if (dao.delete(id)) {
			alert = new Alert("Rol Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);

	}

	private void mostrarFormulario(HttpServletRequest request) {
		Rol rol = new Rol();
		if (id > -1) {
			rol = dao.getById(id);

		} else {
			alert = new Alert("Nuevo rol", Alert.TIPO_WARNING);
		}
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void listar(HttpServletRequest request) {
		ArrayList<Rol> roles = new ArrayList<Rol>();
		roles = dao.getAll();
		request.setAttribute("roles", roles);
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
		} else {
			op = 0;
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = -1;
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		} else {
			nombre = "";
		}

	}

}
