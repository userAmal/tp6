package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Reservation;
import util.JPAutil;

public class ReservationDaoImpl implements IReservationDAO {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE");

	@Override
	public Reservation save(Reservation p) {

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
	}

	@Override
	public List<Reservation> ReservationsParMC(String mc) {
	    List<Reservation> reservations = entityManager.createQuery("SELECT r FROM Reservation r WHERE r.nomClient LIKE :mc").setParameter("mc", "%" + mc + "%").getResultList();
	    return reservations;
	}


	@Override
	public Reservation getReservation(Long id) {
		return entityManager.find(Reservation.class, id);
	}

	@Override
	public Reservation updateReservation(Reservation p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
	}

	@Override
	public void deleteReservation(Long id) {
		Reservation produit = entityManager.find(Reservation.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(produit);
		entityManager.getTransaction().commit();
	}
}
