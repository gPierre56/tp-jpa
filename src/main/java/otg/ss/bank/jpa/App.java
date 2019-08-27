package otg.ss.bank.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import otg.ss.bank.jpa.domain.Account;
import otg.ss.bank.jpa.domain.Address;
import otg.ss.bank.jpa.domain.Agency;
import otg.ss.bank.jpa.domain.ChargedAccount;
import otg.ss.bank.jpa.domain.SimpleAccount;
import otg.ss.bank.jpa.domain.Transaction;
import otg.ss.bank.jpa.domain.Transaction.Type;
import otg.ss.bank.jpa.domain.TransactionId;

public class App {

	public static void main(String... args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("persist-unit");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Agency agency = new Agency();
			agency.setCode("UYUVUYG");
			Address address = new Address("2", "Washington street", "46544", "New York");
			agency.setAddress(address);

			em.persist(agency);

			SimpleAccount simpleAccount = new SimpleAccount(5000, 0);
			em.persist(simpleAccount);
			ChargedAccount chargedAccount = new ChargedAccount(500, 2);
			em.persist(chargedAccount);
			agency.addAccount(simpleAccount);

			Transaction transaction = new Transaction(new TransactionId(1L, 1L), Type.IPM, 200, 100);
			transaction.setAccount(em.find(Account.class, 1L));
			transaction.setAgency(em.find(Agency.class, 1L));
			transaction.setAmount(500);
			em.persist(transaction);

//			Query query = em.createNamedQuery("select agency from Agency agency where agency.id=3");
//			Agency test = (Agency) query.getSingleResult();
//			System.out.println(test);

			em.getTransaction().commit();

//			em.getTransaction().begin();
//			Agency a = em.find(Agency.class, 2L);
//			a.setCode("ZZZZZ");
//			em.merge(a);
//			em.getTransaction().commit();
//
//			em.getTransaction().begin();
//			Agency a2 = em.find(Agency.class, 1L);
//			em.remove(a2);
//			em.getTransaction().commit();

		} finally {
			if (em != null) {
				em.close();
			}

			if (emf != null) {
				emf.close();
			}
		}

	}
}
