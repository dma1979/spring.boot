package by.dma.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.dma.jpa.entity.Customer;

/**
 * @author : Dzmitry Marudau
 * @created at : 00:35
 * @since : 2019.12
 **/
@Repository
@Transactional
public class PlainHibernateCustomerRepository implements ICustomerRepository {

  @PersistenceContext
  private EntityManager em;

  private Session getSession() {
    return em.unwrap(Session.class);
  }

  @Override
  public List<Customer> findAll() {
    String hql = "SELECT c FROM Customer c";
    var query = getSession().createQuery(hql, Customer.class);
    return query.getResultList();
  }

  @Override
  public Customer findById(long id) {
    return getSession().find(Customer.class, id);
  }

  @Override
  public Customer save(Customer customer) {
    getSession().persist(customer);
    return customer;
  }

  @Override
  public void delete(Customer customer) {
    getSession().delete(customer);
  }
}
