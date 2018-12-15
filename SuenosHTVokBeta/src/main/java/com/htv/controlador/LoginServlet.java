package com.htv.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htv.models.Usuario;
import com.htv.persistencia.UsuarioEM;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		System.gc();
		 

		if (session.getAttribute("nombre")!=null) {
			request.getRequestDispatcher("sueno.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		Usuario usuarioLoginValidando = UsuarioEM.getInstance().getLoginUsuario(nombre, contraseña);
		System.out.println("validando usuario em login do post usuarioLoginValidando = " + usuarioLoginValidando);
		System.out.println("nombre = "+nombre);
		System.out.println("contraseña = "+contraseña);
		if(usuarioLoginValidando!=null) {
			
			
			 HttpSession session = request.getSession();
			
			 session.setAttribute("nombre", usuarioLoginValidando.getNombre());
			
			 request.getRequestDispatcher("sueno.jsp").forward(request, response);	
		}else {
			request.setAttribute("error", "el nombre o usuario es incorrecto!!!");
			this.doGet(request, response);
		}

		doGet(request, response);
	}

}
