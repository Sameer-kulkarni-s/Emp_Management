package Emp_Management.DAO;

import java.util.List;
import Emp_Management.Model.Employee;
    
public interface EmployeeDAO {
        // standard database operations:
        // CRUD aka RUDI
        // Create/Read/Update/Delete or Read/Update/Delete/Insert
    
boolean insertEmployee( Employee employee );
    
Employee getempid(int id);
Employee getidbyname(String name);
List<Employee> getAllemployees();
    
boolean updateEmployees(int id, Employee name);
    
boolean deleteemployee(int id);
    

}
    