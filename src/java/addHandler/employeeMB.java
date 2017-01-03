package addHandler;

import dao.addDao;
import dao.editDao;
import entity.Employee;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class employeeMB {

    Employee employee = new Employee();
    Employee newEmployee = new Employee();
    editDao editDao = new editDao();

    public Employee getNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(Employee newEmployee) {
        this.newEmployee = newEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String addemployee() {
        if (employee.getFname().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "First Name Required", ""));
        } else if (employee.getLname().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Last Name Required", ""));
        } else if (employee.getGender().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gender Required", ""));
        }else {
            employee.setFname(employee.getFname());
            employee.setLname(employee.getLname());
            employee.setGender(employee.getGender());
            employee.setSalary(employee.getSalary());
            employee.setAddress(employee.getAddress());
            employee.setDistrict(employee.getDistrict());
            employee.setCountry(employee.getCountry());
            employee.setPhone(employee.getPhone());
            employee.setEmail(employee.getEmail());
            employee.setDateofBirth(employee.getDateofBirth());
            boolean status = new addDao().addEmployee(employee);
            if (status) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error to Save Data", ""));
            }
        }
        return null;
    }
    public void changeEmp(Employee employee){
        this.newEmployee = employee;
    }
    
    public void updateEmployee(Employee newEmployee){
        String Name = newEmployee.getFname();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Name", Name);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);  
        editDao.updateEmp(newEmployee);  
        System.out.println("User Info successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User updated successfully .");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        newEmployee = new Employee();
    }
    public void deleteEmployee(Employee employee)  
    {     
        editDao.deleteEmp(employee);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    } 

    public String empAdd() {
        //System.out.print("asdfsad");
        return "addEmployee?faces-redirect=true";
    }

    public String empDetails() {
        return "employeeDetails?faces-redirect=true";
    }

    public String empUpdate(){
        return "updateEmployee?faces-redirect=true";
    }
}
