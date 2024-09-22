package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";
  private static final Logger LOGGER = Logger.getLogger(CreditCardsMain.class.getName());

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
         EntityManager em = factory.createEntityManager()) {

      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
      LOGGER.log(Level.INFO, "Transaction committed successfully.");
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error occurred: ", e);
    }
  }

  private static void createObjects(EntityManager em) {
    Bank bank = new Bank();
    bank.setName("Pengebank");
    em.persist(bank);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);
    em.persist(pincode);

    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    card1.setPincode(pincode);
    card1.setOwningBank(bank);
    em.persist(card1);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setPincode(pincode);
    card2.setOwningBank(bank);
    em.persist(card2);

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    em.persist(address);

    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.addAddress(address);
    customer.addCreditCard(card1);
    customer.addCreditCard(card2);
    em.persist(customer);
  }

}
