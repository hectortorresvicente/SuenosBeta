package com.htv.persistencia;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.htv.models.Sueno;
import com.htv.models.Usuario;

public class SuenoEM extends EntityManager {

	private static SuenoEM instance = null;

	public static final SuenoEM getInstance() {
		if (instance == null)
			instance = new SuenoEM();
		return instance;
	}

	protected SuenoEM() {
		super();
	}

	public List<Sueno> getListaSuenos() { /* todos los sueños */
		List<Sueno> suenos = null;
		try {
			/* Hibernate */

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
//			System.out.println("1 antes de hacer la petición a la bbdd");
			suenos = session.createQuery("FROM Sueno ", Sueno.class).getResultList();
//			System.out.println("2 despues de hacer la petición a la bbdd");
//			System.out.println("3 despues de hacer la petición a la bbdd, objetos recogidos =" + suenos.size());
			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mal echa la petición");
		}

		return suenos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Sueno> getListaSuenosPorUsuario(int idu) { /* todos los sueños por usuario */
		
		List<Sueno> Sueno = null;
			Session session = null;
			try {
				int SuenoIdu = idu;
				session = factory.openSession();
				Transaction tx = session.beginTransaction();
				Query query = session.createQuery("FROM Sueno WHERE idu = :idu", Sueno.class);
				query.setParameter("idu", SuenoIdu);
				Sueno = (List<Sueno>) query.getResultList();
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
			return Sueno;
		}

	public boolean NuevoSueno(Sueno SueñoNuevo) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(SueñoNuevo);
		trans.commit();
		session.close();
		return true;

	}

	public boolean BorrarSuenoById(int ids) {
		boolean result = false;
		Session session = null;

		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Sueno uDelete = new Sueno();
		uDelete = session.load(Sueno.class, ids);
		uDelete.setIds(ids);

		session.delete(uDelete);
		tx.commit();
		session.close();
//		System.out.println("Sueno eliminado" + result);

		return result;

	}

	public Sueno getSuenoById(int ids) {
		Sueno Sueno = null;
		Session session = null;
		try {
			int SuenoIds = ids;
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("FROM Sueno WHERE ids = :ids", Sueno.class);
			query.setParameter("ids", SuenoIds);
			Sueno = (Sueno) query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return Sueno;
	}
	public Usuario getUsuarioByIdLogin(String nombre) {
		Usuario usuario = null;
		Session session = null;
		try {
			String UsuarioNombre = nombre;
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("antes de peticion de usaurioEm 2, nombre="+ UsuarioNombre);
			Query query = session.createQuery("FROM Usuario WHERE Nombre = :Nombre", Usuario.class);
			query.setParameter("Nombre", UsuarioNombre);
			usuario = (Usuario) query.getSingleResult();
			System.out.println("despues de peticion de usaurioEm 3, usuario="+ usuario);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usuario;
	}

	public  boolean updateSueno(Sueno SueñoModificado, int ids) throws Exception {
		boolean isOkS = false;

		System.out.println("en  updateSueno recogiendo SueñoModificado = " + SueñoModificado + " ids= " + ids);
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Sueno suenoDB = session.load(Sueno.class, ids);

		suenoDB.setTitulo(SueñoModificado.getTitulo());
		suenoDB.setSueno(SueñoModificado.getSueno());
		suenoDB.setComentario(SueñoModificado.getComentario());

		session.update(suenoDB);

		t.commit();
		session.close();

		isOkS = true;

		return isOkS;
	}

	
}

// public Sueno getSuenoUno(int idsU)/* solo un sueño llamar editar */ {
//
// Sueno listaModuloAlumno = new Sueno();
//
// int nId = 0;
// try {
// /* Hibernate */
//
// Session session = factory.openSession();
// System.out.println("1 antes de hacer la petición a la bbdd en getSuenoUno");
// Transaction t = session.beginTransaction();
// listaModuloAlumno = (Sueno) session.createQuery("FROM Sueno WHERE Sueno.ids =
// :idsU")/* consigo un sueño */
// .setInteger("idsU", idsU).getSingleResult();
// System.out.println("2 despues de hacer la petición a la bbdd en getSuenoUno"
// + listaModuloAlumno);
//
// t.commit();
// session.close();
// /* Hibernate */
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// return listaModuloAlumno;
// }
//
// public List<Sueno> putSuenoUno(int userCurso)/* solo un sueño modificar */ {
//
// List<Sueno> listaModuloAlumno = new ArrayList<Sueno>();
//
// int nId = 0;
// try {
// /* Hibernate */
//
// Session session = factory.openSession();
//
// Transaction t = session.beginTransaction();
// listaModuloAlumno = (List<Sueno>) session.createQuery("from modulo WHERE
// modulo.idm = :mid")/*
// * consigo los
// * modulos del
// * alumno
// */
// .setInteger("mid", userCurso).getSingleResult();
//
// t.commit();
// session.close();
// /* Hibernate */
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// return listaModuloAlumno;
// }
//
// public List<Sueno> deleteSuenoUno(int userCurso)/* solo un sueño borrar */ {
//
// List<Sueno> listaModuloAlumno = new ArrayList<Sueno>();
//
// int nId = 0;
// try {
// /* Hibernate */
//
// Session session = factory.openSession();
//
// Transaction t = session.beginTransaction();
// listaModuloAlumno = (List<Sueno>) session.createQuery("from modulo WHERE
// modulo.idm = :mid")/*
// * consigo los
// * modulos del
// * alumno
// */
// .setInteger("mid", userCurso).getResultList();
//
// t.commit();
// session.close();
// /* Hibernate */
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// return listaModuloAlumno;
// }
//
// public boolean save(Sueno emp) {
// Session session = factory.openSession();
// Transaction t = session.beginTransaction();
//
// session.save(emp);
//
// t.commit();
// session.close();
//
// return true;
//
// }

// }
