package Employee_Management.DAO;

import Employee_Management.Model.Employee;

public  abstract class EmployeeDBAbstract implements EmployeeDAO {


    @Override
    public boolean updateEmployees(int id, Employee Employee) {
        if ( ! deleteemployee(id) ) return false;
        return insertEmployee(Employee);
   
    }
}
