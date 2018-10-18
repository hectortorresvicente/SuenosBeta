package com.htv.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.htv.models.Sueno;
import com.htv.models.Usuario;

public class UsuarioEM extends EntityManager {

	private static UsuarioEM instance = null;

	public static final UsuarioEM getInstance() {
		if (instance == null)
			instance = new UsuarioEM();
		return instance;
	}

	protected UsuarioEM() {
		super();
	}

	// ---------------------USUARIO------------------------------//

	public List<Usuario> getListaUsuario() {
		List<Usuario> Usuarios = null;
		try {
			/* Hibernate */

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			// System.out.println("1 UsuarioEM getListaUsuario antes de hacer la petición a
			// la bbdd");
			Usuarios = session.createQuery("FROM Usuario ", Usuario.class).getResultList();
			// System.out.println("2 UsuarioEM getListaUsuario despues de hacer la petición
			// a la bbdd = " + Usuarios);
			// System.out.println("3 UsuarioEM getListaUsuario despues de hacer la petición
			// a la bbdd, objetos recogidos =" + Usuarios.size());
			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mal echa la petición");
		}

		return Usuarios;
	}

	public Usuario getUnUsuario(String nombre) {
		Usuario Usuario = null;
		Session session = null;
		try {

			String UsaurioNombre = nombre;
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("FROM Usuario WHERE nombre = :nombre", Usuario.class);
			query.setParameter("nombre", UsaurioNombre);
			Usuario = (Usuario) query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return Usuario;
	}

	public boolean updateUsuario(Usuario UsaurioModificado, int idu) throws Exception {
		boolean isOkS = false;

		System.out.println("en  updateSueno recogiendo UsuarioModificado = " + UsaurioModificado + " idu= " + idu);

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Usuario suenoDB = session.load(Usuario.class, idu);
		System.out.println("guardamos el usuario modificado en EM de Ussuario");

		suenoDB.setNombre(UsaurioModificado.getNombre());
		suenoDB.setCorreo(UsaurioModificado.getCorreo());
		suenoDB.setContraseña(UsaurioModificado.getContraseña());

		session.update(suenoDB);

		t.commit();
		session.close();

		isOkS = true;

		return isOkS;
	}
	
	public boolean NuevoUsuario(Usuario newUsuario) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(newUsuario);
		trans.commit();
		session.close();
		return true;

	}

	public boolean BorrarUsaurioId(int idu) {
		boolean result = false;
		Session session = null;

		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Usuario uDelete = new Usuario();
		uDelete = session.load(Usuario.class, idu);
		uDelete.setIdu(idu);

		session.delete(uDelete);
		tx.commit();
		session.close();
		// System.out.println("Sueno eliminado" + result);

		return result;

	}

	// ----------------------------------------LOGIN-------------------------------//
	public Usuario getLoginUsuario(String nombre, String contraseña) {
		Usuario usuario = null;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "FROM Usuario WHERE (nombre = :nombre) AND (contraseña = :contraseña)";
			Query query = session.createQuery(hql, Usuario.class);
			query.setParameter("nombre", nombre);
			query.setParameter("contraseña", contraseña);
			usuario = (Usuario) query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		System.out.println(String.format("UsuarioEM.getUsuario(%s, %s) = %s", nombre, contraseña, usuario));
		System.out.println("estoy en usuarioEm getLoginUsuario = " + usuario);
		return usuario;

	}

	public Usuario getLoginUsuarioDos(String nombre, String contraseña) {
		Usuario Usuario = null;
		try {
			/* Hibernate */

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			// System.out.println("1 UsuarioEM getListaUsuario antes de hacer la petición a
			// la bbdd");
			Usuario = session
					.createQuery("FROM Usuario WHERE u.nombre :nombre AND u.contraseña :contraseña", Usuario.class)
					.setString("nombre", nombre).setString("contraseña", contraseña).getSingleResult();
			// System.out.println("2 UsuarioEM getListaUsuario despues de hacer la petición
			// a la bbdd = " + Usuarios);
			// System.out.println("3 UsuarioEM getListaUsuario despues de hacer la petición
			// a la bbdd, objetos recogidos =" + Usuarios.size());
			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mal echa la petición");
		}

		return Usuario;
	}

}
