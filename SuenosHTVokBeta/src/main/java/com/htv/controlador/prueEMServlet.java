package com.htv.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htv.bbdd.SuenoDAO;
import com.htv.models.Sueno;
import com.htv.models.Usuario;
import com.htv.persistencia.SuenoEM;
import com.htv.persistencia.UsuarioEM;

@WebServlet("/em")
public class prueEMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Sueno> ListaSuenoEM;
		List<Usuario> ListaUsuariosEM;
		
		ListaUsuariosEM = UsuarioEM.getInstance().getListaUsuario();
		request.setAttribute("ListaUsuariosEM", ListaUsuariosEM);
		
		
		ListaSuenoEM = SuenoEM.getInstance().getListaSuenos();
		request.setAttribute("ListaSuenoEM", ListaSuenoEM);
//		System.out.println("estoy en el servlet con la info  ="  + ListaSuenoEM );
		try {
			
			
			List<Sueno> ListaSuenoDAO;
			ListaSuenoDAO = SuenoDAO.getInstance().getLista();
			request.setAttribute("ListaSuenoDAO", ListaSuenoDAO);
//			System.out.println("estoy en el servlet con la info DAO  ="  + ListaSuenoDAO );
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("prueem.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
