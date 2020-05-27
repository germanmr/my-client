package com.mycompany.myclient.repository;

import com.mycompany.myclient.model.CountryCode;
import com.mycompany.myclient.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class PhoneRepository {

    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Phone findById(Long id) {
        return em.find(Phone.class, id);
    }

    public Phone save(Phone phone) {

        if (phone.getId() == null) {
            em.persist(phone);
        } else {
            em.merge(phone);
        }

        return phone;
    }

    public void deleteById(Long id) {
        Phone phone = findById(id);
        logger.info("Recovered phone: " + phone);
        em.remove(phone);
    }

    public void savePhoneWithCountryCode() {
        CountryCode countryCode = new CountryCode("Argentina", "+54");
        em.persist(countryCode);

        Phone phone = new Phone("Home phone", "123456789");

        phone.setCountryCode(countryCode);
        em.persist(phone);
    }

    public void someOperationToUnderstandPersistenceContext() {
        //Database Operation 1 - Retrieve student
        Phone phone = em.find(Phone.class, 20001L);
        //Persistence Context (student)


        //Database Operation 2 - Retrieve passport
        CountryCode countryCode = phone.getCountryCode();
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        countryCode.setName("Argentina");
        countryCode.setName("+54");
        //Persistence Context (student, passport++)

        //Database Operation 4 - update phone
        phone.setDescription("Work Phone");
        //Persistence Context (student++ , passport++)
    }

//    public void insertStudentAndCourse() {
//        Phone phone = new Phone("Jack","123456789");
//        Course course = new Phone("Microservices in 100 Steps");
//        em.persist(student);
//        em.persist(course);
//
//        student.addCourse(course);
//        course.addStudent(student);
//        em.persist(student);
//    }

//    public void insertStudentAndCourse(Student student, Course course) {
//        //Student student = new Student("Jack");
//        //Course course = new Course("Microservices in 100 Steps");
//        student.addCourse(course);
//        course.addStudent(student);
//
//        em.persist(student);
//        em.persist(course);
//    }

}
