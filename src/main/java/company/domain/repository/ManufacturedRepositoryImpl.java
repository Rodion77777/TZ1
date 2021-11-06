package company.domain.repository;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufacturedRepositoryImpl implements ManufacturedRepository
{
    @Override
    public ManufacturerEntity findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ManufacturerEntity manufacturerEntity = session.get(ManufacturerEntity.class, id);
        session.close();
        return manufacturerEntity;
    }

    @Override
    public void save(ManufacturerEntity manufacturerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacturerEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(ManufacturerEntity manufacturerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(manufacturerEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ManufacturerEntity manufacturerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(manufacturerEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ManufacturerEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<ManufacturerEntity> manufacturerEntityList = session.createQuery("from ManufacturerEntity ").list();
        session.close();
        return manufacturerEntityList;
    }

    @Override
    public List<ManufacturerEntity> findByCountryEntity(CountryEntity countryEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<ManufacturerEntity> manufacturerEntityList = session.createQuery("from ManufacturerEntity where CountryEntity = :countryEntity").setParameter("countryEntity", countryEntity).getResultList();
        session.close();
        return manufacturerEntityList;
    }

    public void clearManufacturersTable ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete ManufacturerEntity ").executeUpdate();
        transaction.commit();
        session.close();
    }
}