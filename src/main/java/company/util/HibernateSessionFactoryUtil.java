package company.util;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil
{
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil () {}

    public static SessionFactory getSessionFactory ()
    {
        if (sessionFactory == null)
        {
            try {
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(CountryEntity.class);
                configuration.addAnnotatedClass(ManufacturerEntity.class);
                configuration.addAnnotatedClass(ProductEntity.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}
