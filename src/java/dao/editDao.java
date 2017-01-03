
package dao;

import entity.Employee;
import entity.Product;
import org.hibernate.Session;
import util.HibernateUtil;

public class editDao {
    
    private Employee employee;
    private Employee newEmployee;
    private Product product;
    private Product newProduct;
    
    public void deleteEmp(Employee employee)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            String name = employee.getFname();  
            session.beginTransaction();  
            session.delete(employee);  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }
    public void updateEmp(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            session.update(employee);  
            session.flush();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
    }
    
    public void updatePro(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            session.update(product);  
            session.flush();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();
    }
    public void deletePro(Product product)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            String name = product.getProName();  
            session.beginTransaction();  
            session.delete(product);  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }
}
