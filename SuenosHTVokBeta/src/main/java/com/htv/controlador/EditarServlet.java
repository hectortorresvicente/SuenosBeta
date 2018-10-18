package com.htv.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htv.bbdd.BBDD;
import com.htv.models.Sueno;
import com.htv.persistencia.SuenoEM;

@WebServlet("/editar")
public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("nombre")!=null) {

		int ids = Integer.parseInt(request.getParameter("ids"));
		Sueno listaSuenoSeleccionado = SuenoEM.getInstance().getSuenoById(ids);
		request.setAttribute("listaSuenoSeleccionado", listaSuenoSeleccionado);
		
//		System.out.println("ids adquirido" + listaSuenoSeleccionado);
		
//		boolean SeModifico= false;
		
		

		request.getRequestDispatcher("editar.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entrandop en editando sueno");
		int idsD = Integer.parseInt(request.getParameter("ids"));
		Sueno listaSuenoSeleccionado = BBDD.getSueñoSeleccionado(idsD);
	

		int ids = Integer.parseInt(request.getParameter("ids"));
		String titulo = request.getParameter("titulo");
		String sueno = request.getParameter("sueno");
		String comentario = request.getParameter("comentario");
//		int idus = Integer.parseInt(request.getParameter("idus"));
		
		Sueno SueñoModificado = new Sueno(ids, titulo, sueno, comentario);
		
		System.out.println("en editar servlet recogiendo SueñoModificado= " + SueñoModificado);
		try {
			boolean isOkS = SuenoEM.getInstance().updateSueno(SueñoModificado, ids);
			
			System.out.println("en editar servlet recogiendo isOkS= " + isOkS);
			
			
		} catch (Exception e) {
			System.out.println("petición mal realizada, estamos en dopost editarservlet" );
			e.printStackTrace();
		}
		
		
//		boolean SeModifico= false;
//		
//		if (listaSuenoSeleccionado.getTitulo() != SueñoModificado.getTitulo()
//				& listaSuenoSeleccionado.getSueno() != SueñoModificado.getSueno()
//				& listaSuenoSeleccionado.getComentario() != SueñoModificado.getComentario()) {
//			SeModifico= true;
//		}else{
//			request.setAttribute("error", "no hay nada que modificar");}  /// hacer que chute
		
		boolean isOk = BBDD.getInstancia().modificancoSueno(SueñoModificado);
		
	
		doGet(request, response);
	}

}
