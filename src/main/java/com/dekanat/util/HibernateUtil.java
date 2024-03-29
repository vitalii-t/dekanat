package com.dekanat.util;

import com.dekanat.entities.Lesson;
import com.dekanat.entities.Registry;
import com.dekanat.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Lesson.class);
            configuration.addAnnotatedClass(Registry.class);
            configuration.configure();
            return configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
