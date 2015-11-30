import com.sun.prism.impl.Disposer;
import models.BooksEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.math.BigDecimal;

/**
 * Created by ekot on 21.11.15.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        Main m = new Main();
        BooksEntity be = new BooksEntity();

        int record = 16;//numer rekordu w tabeli do wpisywania lub updateowania

        be.setId(record);
        be.setTitle("The lord of the Rings");
        be.setAuthor("Jakis tam");
        be.setPrice(new BigDecimal(9.99));
        be.setKategoria(2);
        be.setWydawnictwo_id(3);
//        m.get(8);
//        m.addRecord(be);
//        m.updateRecord(be);
        m.deleteRecord(19);
    }

    public Integer addRecord(BooksEntity be) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = null;
        try {
            trns = session.beginTransaction();
            id = (Integer) session.save(be);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return id;
    }

    public void deleteRecord(int record_id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            BooksEntity be = (BooksEntity) session.load(BooksEntity.class, new Integer(record_id));
            session.delete(be);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateRecord(BooksEntity book) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public BooksEntity get(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        BooksEntity returned = null;
        try {
            trns = session.beginTransaction();
            returned = (BooksEntity) session.get(BooksEntity.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return returned;
    }
    public List list() {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        List objects = new LinkedList();
        try {
            trns = session.beginTransaction();
            objects = session.createQuery("FROM BooksEntity").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return objects;
    }
}
