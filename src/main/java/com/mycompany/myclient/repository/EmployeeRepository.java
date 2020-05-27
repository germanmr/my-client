package com.mycompany.myclient.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	EntityManager em;
//
//	public void insert(Employee employee) {
//		em.persist(employee);
//	}
//
//	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
//		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
//	}
//
//	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
//		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
//	}
}