package product_management.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.ConnectionUtil;
import product_management.repository.IProductRepository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT p FROM Product AS p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;


        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> finByName(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.productName like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
