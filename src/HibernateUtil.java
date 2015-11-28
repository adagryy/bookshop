import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Adam on 28.11.2015.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch(Throwable th){
            System.err.println("Enitial SessionFactory creation failed"+th);
            throw new ExceptionInInitializerError(th);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
