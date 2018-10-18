package com.htv.controlador;

import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htv.bbdd.BBDD;
import com.htv.models.Sueno;
import com.htv.persistencia.SuenoEM;

@WebServlet("/nuevo")
public class nuevoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("nombre")!=null) {
			
			int idUsuario = Integer.parseInt(request.getParameter("idu"));
			request.setAttribute("idUsuario", idUsuario);
			
			Calendar calendario = Calendar.getInstance();
			int año =calendario.get(Calendar.YEAR);
			int mes =calendario.get(Calendar.MONTH);
			int dia =calendario.get(Calendar.DAY_OF_MONTH);
			int hora =calendario.get(Calendar.HOUR_OF_DAY);
			int minutos =calendario.get(Calendar.MINUTE);
			int milisegundos =calendario.get(Calendar.ERA);
			Calendar calendarioGregorian = new GregorianCalendar();
			
			Date fecha = new Date();
			Date horaDate = new Date();
			
			request.setAttribute("fecha", fecha);
			
			System.out.println("año= "+año+", mes= "+mes+", dia= "+dia+", hora= "+hora+", minuto= "+minutos);
			System.out.println("fecha= "+fecha);
			System.out.println("horaDate= "+horaDate.getHours());
			int hours = 3;
			System.out.println("calendarioGregorian= "+ calendarioGregorian.DATE);
		request.getRequestDispatcher("nuevo.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		int idu = Integer.parseInt(request.getParameter("idu"));
		String titulo = request.getParameter("titulo");
		String sueno = request.getParameter("sueno");
		String comentario = request.getParameter("comentario");
//		int idus = Integer.parseInt(request.getParameter("idus"));

		Sueno SueñoNuevo = new Sueno(0, titulo, sueno, comentario, idu);
		System.out.println("sueno generado= "+ SueñoNuevo);
		boolean isOk = SuenoEM.getInstance().NuevoSueno(SueñoNuevo);
		System.out.println("sueno generado= "+ SueñoNuevo);

//		System.out.println(SueñoNuevo.getIds() + SueñoNuevo.getTitulo() + SueñoNuevo.getSueno()
//				+ SueñoNuevo.getComentario() + "  Sueño nuevos add en servlet nuevo");
		
		

		doGet(request, response);
	}

}
