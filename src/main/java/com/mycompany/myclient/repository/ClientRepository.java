package com.mycompany.myclient.repository;

import com.mycompany.myclient.model.Address;
import com.mycompany.myclient.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * We use this repository for more complex actions on database!
 */
@Repository
@Transactional
public class ClientRepository {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Client findById(Long id) {
        return em.find(Client.class, id);
    }

    public Client save(Client client) {

        if (client.getId() == null) {
            em.persist(client);
        } else {
            em.merge(client);
        }

        return client;
    }

    public void deleteById(Long id) {
        Client client = findById(id);
        em.remove(client);
    }

//	public void playWithEntityManager() {
//		Course course1 = new Course("Web Services in 100 Steps");
//		em.persist(course1);
//
//		Course course2 = findById(10001L);
//
//		course2.setName("JPA in 50 Steps - Updated");
//
//	}

//	public void addHardcodedReviewsForCourse() {
//		//get the course 10003
//		Course course = findById(10003L);
//		logger.info("course.getReviews() -> {}", course.getReviews());
//
//		//add 2 reviews to it
//		Review review1 = new Review("5", "Great Hands-on Stuff.");
//		Review review2 = new Review("5", "Hatsoff.");
//
//		//setting the relationship
//		course.addReview(review1);
//		review1.setCourse(course);
//
//		course.addReview(review2);
//		review2.setCourse(course);
//
//		//save it to the database
//		em.persist(review1);
//		em.persist(review2);
//	}

    public void addAddressForClient(Long courseId, List<Address> addresses) {
        Client client = findById(courseId);
        logger.info("client.getAddress() -> {}", client.getAddress());
        for (Address address : addresses) {
            //setting the relationship
            client.addAddress(address);
            address.setClient(client);
            em.persist(address);
        }
    }
}