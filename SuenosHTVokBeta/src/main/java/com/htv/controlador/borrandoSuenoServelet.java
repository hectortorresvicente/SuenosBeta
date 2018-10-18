package com.htv.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htv.bbdd.BBDD;
import com.htv.persistencia.SuenoEM;


@WebServlet("/borrar")
public class borrandoSuenoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("nombre")!=null) {
		
//		System.out.println("estoy en  /borrar entrando");
		boolean isOk=false;
		String code="";
		try {
			int ids=Integer.parseInt(request.getParameter("ids"));
//			code=request.getParameter("code");
			System.out.println("estoy en  /borrar en el try");
			
			isOk=SuenoEM.getInstance().BorrarSuenoById(ids);
			
//			isOk=BBDD.getInstancia().borrandoSueño(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!isOk) request.setAttribute("error", "Ha habido un error");
		System.out.println("estoy en  /borrar Saliendo");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	

}
