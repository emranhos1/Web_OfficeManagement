/**
 *
 * @author Emran
 */
package dao;

import entity.Employee;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class addDao {
    public boolean addProduct(Product pro){
        try{
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(pro);
        session.getTransaction().commit();
        session.close();
        return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean addEmployee(Employee emp){
    try{
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
        return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
