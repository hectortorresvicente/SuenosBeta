package com.htv.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htv.bbdd.BBDD;
import com.htv.models.H;
import com.htv.models.Usuario;
import com.htv.persistencia.UsuarioEM;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String docHtml= "<form action=\"\" method=\"post\">\r\n" + 
				"\r\n" + 
				"		<div>\r\n" + 
				"			<label>Idu: </label><span type=\"text\" name=\"ids\" placeholder=\"idu\"\r\n" + 
				"				value=\"0\"> 0 </span>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"		<div>\r\n" + 
				"			<label>Nombre </label><input type=\"nombre\" name=\"nombre\"\r\n" + 
				"				placeholder=\"nombre\" value=\"Nombre\" />\r\n" + 
				"		</div>\r\n" + 
				"		 <div>\r\n" + 
				"			<label>Correo </label><input type=\"correo\" name=\"correo\"\r\n" + 
				"				placeholder=\"correo\" value=\"Correo\" />\r\n" + 
				"		</div> \r\n" + 
				"		<div>\r\n" + 
				"			<label>Contraseña </label><input type=\"contrasena\" name=\"contrasena\"\r\n" + 
				"				placeholder=\"contraseña\" value=\"Contrasena\" />\r\n" + 
				"		</div>\r\n" + 
				"		\r\n" + 
				"		\r\n" + 
				"		\r\n" + 
				"		\r\n" + 
				"\r\n" + 
				"			<button onclick=\"\">Entrar</button>\r\n" + 
				"	</form>";
		
		List<H> impre=BBDD.getInstancia().getH();
		int impreeD = impre.size();
		
		if(impreeD==1) {;
			out.println(docHtml);
			request.setAttribute("docHtml", docHtml);
		}
		request.setAttribute("impreeD", impreeD);
		
		
System.out.println("valr de imprim  =  "+impre);
		request.getRequestDispatcher("registrou.jsp").forward(request, response);
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setBufferSize(8192 * 16); // <-- **** BUFFER **** modificar bufer para la respuesta asincrona
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		
		boolean isok = true;
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");

		Usuario newUsuario = new Usuario(0, correo, nombre, contrasena);

		try {
			if (response.isCommitted()) {
			 response.resetBuffer();
			}
			 
			boolean isOk = UsuarioEM.getInstance().NuevoUsuario(newUsuario);

//			response.sendRedirect("login");
			request.setAttribute("generado", "se genero el usuario correctamente con el nombre = " + nombre
					+ " Correo= " + correo + " contraseña = " + contrasena);
			
			H newH = new H(2);
			
			BBDD.getInstancia().CreacionH(newH);
			
			
			// response.sendRedirect("listaciudades");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error en la generación del usuario");

			request.setAttribute("error", "no se puede generar usuario con los datos: Nombre= " + nombre + " Correo= "
					+ correo + " contraseña = " + contrasena + ". <br> Datos ya existentes");

		}

		doGet(request, response);
	}

}
