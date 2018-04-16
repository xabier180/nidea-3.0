package com.ipartek.formacion.nidea.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class
 * UsuariosConectadosListener
 *
 */
@WebListener
public class UsuariosConectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {

		if (se.getSession().getAttribute("uPublic") != null) {

			Usuario u = (Usuario) se.getSession().getAttribute("uPublic");

			ServletContext ctx = se.getSession().getServletContext();

			if (ctx.getAttribute("usuarios_conectados") != null) {
				HashMap<Integer, Usuario> hmUsuarios = (HashMap<Integer, Usuario>) ctx
						.getAttribute("usuarios_conectados");
				hmUsuarios.remove(u.getId());
				ctx.setAttribute("usuarios_conectados", hmUsuarios);
			}

		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

		// comprobar que sea atributo == uPublic
		if ("uPublic".equals(event.getName())) {

			ServletContext ctx = event.getSession().getServletContext();
			HashMap<Integer, Usuario> hmUsuarios = null;
			if (ctx.getAttribute("usuarios_conectados") == null) {
				hmUsuarios = new HashMap<Integer, Usuario>();
			} else {
				hmUsuarios = (HashMap<Integer, Usuario>) ctx.getAttribute("usuarios_conectados");
			}

			Usuario u = (Usuario) event.getValue();
			hmUsuarios.put(u.getId(), u);
			ctx.setAttribute("usuarios_conectados", hmUsuarios);

		}

		// contexto de la App
		// event.getSession().getServletContext()

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}