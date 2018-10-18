package com.htv.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

@WebServlet("/sueno")
public class SuenosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		try {
			Thread.sleep(250);
			
			if (session.getAttribute("nombre") != null) {

				
				String nombre = (String) session.getAttribute("nombre");
				System.out.println("antes de peticion de usaurio");
				Usuario usuarioRecep = SuenoEM.getInstance().getUsuarioByIdLogin(nombre);
				System.out.println("recogemos usuario actual usuarioRecep" + usuarioRecep);

				request.setAttribute("usuarioRecep", usuarioRecep);

				int idu = usuarioRecep.getIdu();
				List<Sueno> listaSuenoEM = SuenoEM.getInstance().getListaSuenosPorUsuario(idu);
				request.setAttribute("listaSuenoEM", listaSuenoEM);
				request.setAttribute("location", "sueno");
				int totalSuenos = listaSuenoEM.size();
				request.setAttribute("totalSuenos", totalSuenos);
				
				request.getRequestDispatcher("sueno.jsp").forward(request, response);
				
				System.out.println("lista sueños listaSuenoEM = " + listaSuenoEM);
				System.out.println("AAAAAAAAAA  valor totalSuenos " + totalSuenos);

			} else {
				response.sendRedirect("login");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String idsS = request.getParameter("ids");
		// int ids = Integer.parseInt(idsS);
		// boolean isOk = SuenoEM.getInstance().BorrarSuenoById(ids);

		doGet(request, response);
	}

}
