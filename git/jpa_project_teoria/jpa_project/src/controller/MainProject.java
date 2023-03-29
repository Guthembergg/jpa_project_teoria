package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

public class MainProject {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {

		User u = new User();
		u.setName("Mario");
		u.setLastname("Rossi");
		u.setEmail("maio.r@example.comddddd");
//		try {
//			addUser(u);
//		} catch (Exception e) {
//
//		} finally {
//			em.close();
//			emf.close();
//		}

//		User utenteLetto = findUser(1l);
//		System.out.println(utenteLetto);
//		utenteLetto.setName("Mirko");
//		updateUser(utenteLetto );

		System.out.println(findAll());
	}

	public static void addUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente salvato!");
	}

	public static User findUser(Long id) {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.getTransaction().commit();
		return u;
	}

	public static void updateUser(User u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Utente modificato:" + findUser(u.getId()));
	}

	public static void removeUser(User u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Utente rimosso:" + findUser(u.getId()));
	}

	public static List<User> findAll() {
		Query q = em.createNamedQuery("User.findAll");
		return q.getResultList();
	}

}
