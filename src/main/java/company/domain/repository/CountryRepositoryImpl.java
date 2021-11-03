package company.domain.repository;

import company.domain.entity.CountryEntity;
import company.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository
{

    @Override
    public CountryEntity findById(long id)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CountryEntity countryEntity = session.get(CountryEntity.class, id);
        session.close();
        return countryEntity;
    }

    @Override
    public void save(CountryEntity countryEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(countryEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(CountryEntity countryEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(countryEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(CountryEntity countryEntity)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(countryEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<CountryEntity> findAll()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<CountryEntity> countryEntityList = session.createQuery("from CountryEntity").list();
        session.close();
        return countryEntityList;
    }

    public void clearCountriesTable ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete CountryEntity").executeUpdate();
        transaction.commit();
        session.close();
    }
}
