package company.domain.repository;

import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository
{

    @Override
    public ProductEntity findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ProductEntity productEntity = session.get(ProductEntity.class, id);
        session.close();
        return productEntity;
    }

    @Override
    public void save(ProductEntity productEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(productEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(ProductEntity productEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(productEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ProductEntity productEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(productEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ProductEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<ProductEntity> productEntityList = session.createQuery("from ProductEntity ").list();
        session.close();
        return productEntityList;
    }

    @Override
    public List<ProductEntity> findByManufacturerId(ManufacturerEntity manufacturerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<ProductEntity> productEntityList = session.createQuery("from ManufacturerEntity where ProductEntity = :manufacturerEntity").setParameter("manufacturerEntity", manufacturerEntity).getResultList();
        session.close();
        return productEntityList;
    }

    public void clearProductsTable ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete ProductEntity ").executeUpdate();
        transaction.commit();
        session.close();
    }
}