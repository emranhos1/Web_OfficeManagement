
package dao;

import entity.Employee;
import entity.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ListDao {
    
    public List<Employee> allEmployeeList(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Employee> eList = session.createQuery("SELECT al FROM Employee al").list();
        eList.toString();
        session.close();
        return eList;
    }
    public List allProductList(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> pList = session.createQuery("SELECT al FROM Product al").list();
        pList.toString();
        session.close();
        return pList;
    } 
    
}
