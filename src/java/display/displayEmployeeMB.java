
package display;

import dao.ListDao;
import entity.Employee;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class displayEmployeeMB {
    Employee employee = new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public List<Employee> getAllEmployee(){
    List<Employee> eList = new ListDao().allEmployeeList();
        return eList;
    }
}
