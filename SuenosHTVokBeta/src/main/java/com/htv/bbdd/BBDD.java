package com.htv.bbdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.htv.models.Cielo;
import com.htv.models.Geolocalizacion;
import com.htv.models.H;
import com.htv.models.Sueno;
import com.htv.models.Usuario;

public class BBDD {

	private static BBDD instancia = null;
	private static List<Cielo> listaCielo = new ArrayList<>();
	private static List<Geolocalizacion> listaGeolocalizacion = new ArrayList<>();
	private static List<Sueno> listaSueno = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList();
	private static List<H> listaH = new ArrayList();

	public static BBDD getInstancia() {
		if (instancia == null)
			instancia = new BBDD();
		return instancia;
	}

	private BBDD() {
		CreacionUsuario();
		CreacionSueno();
		CreacionGeolocalizacion();
		CreacionCielo();
		CreacionH(null);

	}
	public void Tiempo(String arglist[]) {
		  Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() {
		        int tic=0;

		        @Override
		        public void run()
		        {
		            if (tic%2==0)
		            System.out.println("TIC");
		            else
		            System.out.println("TOC");
		            tic++;
		        }
		        
		        };
		        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		    timer.schedule(task, 10, 1000);
		    
		    }
	
	public void TiempoLanzarrefrescar(String arglist[]) {
		  Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() {
		        int tic=0;

		        @Override
		        public void run()
		        {
		            if (tic%2==0) {
		            System.out.println("TIC");}
		            
		            
		          
		        }
		        
		        };
		        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		    timer.schedule(task, 10);
		    
		    }

	

	

	public boolean CreacionH(H newH) {

		return listaH.add((H) newH);
	}

	final public  List<H> getH() {
		// System.out.println(listaSueno + "estoy en getsue�o");
		return listaH;
	}

	public boolean CreacionUsuario() {
		listaUsuario.add(new Usuario(1, "hola@hola.es", "pedro", "xxx"));
		listaUsuario.add(new Usuario(2, "hol@hola.es", "pedrodos", "xxx"));
		return true;

	}

	public boolean CreacionSueno() {
		listaSueno.add(new Sueno(1, "hola1", "sueno1", "comentario1"));
		listaSueno.add(new Sueno(2, "k tal 2", "sueno2", "comentario2"));
		listaSueno.add(new Sueno(3, "eso va bien 3", "sueno3", "comentario3"));

		// listaSueno.add(new Sueno(1,1170367698406,1170367698406,"sueno
		// 1","comentario1"));
		return true;
	}

	public boolean CreacionGeolocalizacion() {
		listaGeolocalizacion.add(new Geolocalizacion(1, "bcn", "cat", 41.3818, 2.1685));
		return true;
	}

	public boolean CreacionCielo() {
		listaCielo.add(new Cielo(1, "cielo"));
		return true;

	}

	public final static List<Sueno> getSue�o() {
		// System.out.println(listaSueno + "estoy en getsue�o");
		return listaSueno;
	}

	public final static List<Usuario> getUsuario() {
		System.out.println(listaUsuario + "estoy en getusuario");
		return listaUsuario;
	}

	public static Sueno getSue�oSeleccionado(int ids) {
		Sueno encontrado = null;
		for (Sueno sueno : listaSueno) {
			if (sueno.getIds() == ids) {
				encontrado = sueno;
			}

		}
		return encontrado;
	}

	public final boolean modificancoSueno(Sueno sue�oModificado) {
		// System.out.println(sue�oModificado.getTitulo() + " en bbdd
		// modificandoSueno");

		// System.out.println("estoy en modificandooooo!!!!!!!!!!!!!");

		Sueno apuntador = new Sueno(sue�oModificado);

		int SeModifico = 0;

		for (Sueno sueno : listaSueno) {
			if (sueno.getIds() == sue�oModificado.getIds()) {
				sueno.setTitulo(sue�oModificado.getTitulo());
				sueno.setSueno(sue�oModificado.getSueno());
				sueno.setComentario(sue�oModificado.getComentario());
				break;
			}
			if (apuntador.getTitulo() != sue�oModificado.getTitulo()
					& apuntador.getSueno() != sue�oModificado.getSueno()
					& apuntador.getComentario() != sue�oModificado.getComentario()) {
				SeModifico = 1;

			}
		}
		return true;

	}

	public boolean borrandoSue�o(int ids) {
		boolean eliminar = false;
		// System.out.println("estoy en borrando!!!!!!!!!!!!!");
		for (int i = 0; i < listaSueno.size(); i++) {
			if (listaSueno.get(i).getIds() == ids) {
				listaSueno.remove(i);
				eliminar = true;
				break;

			}
		}
		return eliminar;
	}

	public boolean nuevoSueno(Sueno sue�oNuevo) {

		if (sue�oNuevo.getIds() == 0) {
			sue�oNuevo.setIds(listaSueno.size() + 1);

			// return listaSueno.add((Sueno) sue�oNuevo);
		}

		return listaSueno.add(sue�oNuevo);
	}
}
