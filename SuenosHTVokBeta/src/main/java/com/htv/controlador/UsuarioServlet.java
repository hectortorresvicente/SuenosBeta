package com.htv.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htv.bbdd.BBDD;
import com.htv.models.Sueno;
import com.htv.models.Usuario;
import com.htv.persistencia.SuenoEM;
import com.htv.persistencia.UsuarioEM;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		System.out.println("session "  + session);
	
		System.out.println("session  el nombre del usuario "  + session.getAttribute("nombre"));
		
	
//		String nombre = (String) session.getAttribute("nombre");
		
		if (session.getAttribute("nombre") != null) {
			
			
			System.out.println("entrado antes de EM en servlet  " );
			String nombre = (String) session.getAttribute("nombre");			
			List<Usuario> ListUsuario = UsuarioEM.getInstance().getListaUsuario();	
			Usuario UnUsuario = UsuarioEM.getInstance().getUnUsuario(nombre);
			
			System.out.println("despues de la peticion EM en servlet ListUsuario " + ListUsuario );
			System.out.println("despues de la peticion EM en servlet UnUsuario " + UnUsuario );

	
			session.setAttribute("ListUsuario", ListUsuario);
			session.setAttribute("UnUsuario", UnUsuario);
			
			System.out.println("session  el nombre del usuario "  + UnUsuario.getNombre());
			System.out.println("session  el nombre del usuario "  + UnUsuario.getCorreo());
			System.out.println("session  el nombre del usuario "  + UnUsuario.getIdu());

			
			
//			int ids = (int) session.getAttribute("idu"); 
//			Sueno UnUsuario = new Sueno(ids,correo,nombre,contraseña);
//			Usuario UnUsuario = (Usuario) session;
//
//			session.setAttribute("UnUsuario", UnUsuario);
//			System.out.println(" el usuario en sesióbn" + UnUsuario);
			// int ids = Integer.parseInt(request.getParameter("ids"));
			// Sueno UnUsuario = SuenoEM.getInstance().getSuenoById(ids);
			// request.setAttribute("UnUsuario", UnUsuario);

			// System.out.println("ids adquirido" + listaSuenoSeleccionado);

			// boolean SeModifico= false;

			request.getRequestDispatcher("usuario.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("despues de boton formulario " );
				String iduS = request.getParameter("idu");
//		
		int idu = Integer.parseInt(iduS);
		System.out.println("nombre adquirido: " + idu );
		String nombre = request.getParameter("nombre");
		System.out.println("nombre adquirido: " + nombre );
		String correo = request.getParameter("correo");
		System.out.println("nombre adquirido: " + correo );
		String contraseña = request.getParameter("contraseña");
		System.out.println("nombre adquirido: " + contraseña );
//		int idus = Integer.parseInt(request.getParameter("idus"));
		
		Usuario UsaurioModificado = new Usuario( idu, correo, nombre, contraseña);
		
		System.out.println("despues de boton formulario "  + UsaurioModificado );
		
		try {
			boolean isOk = UsuarioEM.getInstance().updateUsuario(UsaurioModificado, idu);
			
			System.out.println("en editar servlet recogiendo isOk= " + isOk);
			if(isOk = true) {
				
				request.setAttribute("mofificado", "se modifico el usuario!!!");
				
	//-------//FALTA GUARDAR EL NUEBVO USUARIO EN LA SESION//-----------
				
				request.getRequestDispatcher("sueno.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("petición mal realizada, estamos en dopost editarservlet" );
			e.printStackTrace();
		}
		
		doGet(request, response);;
	}

}
