/**
 *
 * @author Emran
 */
package addHandler;

import entity.AdminLogin;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


@ManagedBean
@SessionScoped
public class homeMB {
    private List<String> images;
    private String uname;
    private String pass;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public List getImages() {
        images = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            images.add(""+i+".jpg");
        }
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }
    
    public String loginAction(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<AdminLogin> lList = session.createQuery("FROM AdminLogin where name='"+uname+"' and password ='"+pass+"'").list();
        session.close();
        if(lList.size()>0){
            return "admin/admin?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorect Username or Password",""));
            return "login";
        }
       
    }
}
