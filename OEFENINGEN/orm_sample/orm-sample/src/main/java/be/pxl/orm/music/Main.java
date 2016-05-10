package be.pxl.orm.music;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("music");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Deejay deejay = new Deejay();
        deejay.setName("Loco Dice");
        deejay.setHourlyRate(2500l);

        VenuePolicy policy = new VenuePolicy();
        policy.setMinimumAge(18);
        policy.setMustCloseAt(new Date());
        policy.setSecurityCoordinator("Pol");

        Venue venue = new Venue();
        venue.setName("PXL Campus");
        venue.setCity("Hasselt");
        venue.setStreetAndNr("Elfde Liniestraat");
        venue.setZipCode("1000");

        policy.setVenue(venue);

        Party party = new Party();
        party.setName("PXL At The Beach");
        party.setDate(new Date());
        party.setDoorsOpenAt(new Date());
        party.setDeejays(Arrays.asList(deejay));
        party.setVenue(venue);

        entityManager.persist(deejay);
        entityManager.flush();
        transaction.commit();

        entityManager.close();
    }
}
