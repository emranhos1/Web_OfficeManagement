
package addHandler;

import entity.Employee;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

@ManagedBean

public class salaryMB {
    double ot, pardaysalary, total, vat, withoutvat, gross;
    private String first_name, last_name, email, phone, selectedId;
    double salary, tex, advance;
    int overtime;
    //Employee emp = new Employee();
    public String getFirst_name() {
        return first_name;
    }

    public double getOt() {
        return ot;
    }

    public void setOt(double ot) {
        this.ot = ot;
    }

    public double getPardaysalary() {
        return pardaysalary;
    }

    public void setPardaysalary(double pardaysalary) {
        this.pardaysalary = pardaysalary;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getWithoutvat() {
        return withoutvat;
    }

    public void setWithoutvat(double withoutvat) {
        this.withoutvat = withoutvat;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public double getTex() {
        tex = 15;
        return tex;
    }

    public void setTex(double tex) {
        this.tex = tex;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
//        System.out.println(advance);
        this.advance = advance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }
    public List<Employee> getAllEmpId(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Employee> eList = session.createQuery("SELECT al.id FROM Employee al").list();
        eList.toString();
        session.close();
        return eList;
    }
    public void fullInfo(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Employee> fList = session.createQuery("FROM Employee where id='"+selectedId+"'").list();
        setFirst_name(fList.get(0).getFname());
        setLast_name(fList.get(0).getLname());
        setEmail(fList.get(0).getEmail());
        setPhone(fList.get(0).getPhone());
        setSalary(fList.get(0).getSalary());
//        return fList;
    }
    public void mainSalary(){  
        //System.out.println(salary+" sssssssss");
        pardaysalary = salary/30;
        ot = overtime*pardaysalary;
        total = salary+ot;
        //return total;
    }
    public void grossSalary(){
        //getMainSalary();
        vat = tex/100;
        withoutvat = salary -(salary*vat);
        gross = withoutvat+ot-advance;
        //return gross;
    }
    public void calculate(){
    mainSalary();
    grossSalary();
        //System.out.println(total+" --------------");
    }
}
