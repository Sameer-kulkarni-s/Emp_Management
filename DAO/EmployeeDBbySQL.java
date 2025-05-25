package Emp_Management.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Emp_Management.Model.Employee;

public class EmployeeDBbySQL extends EmployeeDBAbstract{

    private static final String SQL_MARIADB_HOST = "localhost";
    private static final String SQL_MARIADB_PORT = "3306";
    private static final String SQL_MARIADB_USER = "root";
    private static final String SQL_MARIADB_PASSWORD = "secret123";
    private static final String SQL_MARIADB_DATABASE = "dbemployees";

    private static final String SQL_MARIADB_CONNECTOR = "org.mariadb.jdbc.Driver";

    private Connection sqlConnection;

    public EmployeeDBbySQL() {
        try {
            Class.forName(SQL_MARIADB_CONNECTOR);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find required SQL driver!");
            e.printStackTrace();
            System.exit(-1);
        }
        connect();
    }

    private void connect() {
        try {
            sqlConnection = DriverManager.getConnection(
                "jdbc:mariadb://" +
                SQL_MARIADB_HOST + ":" + SQL_MARIADB_PORT + "/" +
                SQL_MARIADB_DATABASE, SQL_MARIADB_USER, SQL_MARIADB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Got some problem when establishing SQL connection");
            e.printStackTrace();
            System.exit(-2);
        }        
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        // INSERT INTO account (number, owner, balance) VALUES (?, ?, ?);
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "INSERT INTO attendance (Id, Name, Date, Check_in, Check_out, Hours_Worked) VALUES (?, ?, ?, ?, ?, ?)");
            sqlStatement.setInt(1, employee.getid());
            sqlStatement.setString(2, employee.getname());
            sqlStatement.setDate(3, java.sql.Date.valueOf(employee.getdate()));
            sqlStatement.setTime(3, java.sql.Time.valueOf(employee.getcheck_in()));
            sqlStatement.setTime(3, java.sql.Time.valueOf(employee.getcheck_out()));
            sqlStatement.setBigDecimal(3, employee.gethours_worked());

            return sqlStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getempid(int id) {
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "SELECT Name, Date, Check_in, Check_out, Hours_Worked FROM attendance WHERE id = ?");
            sqlStatement.setInt(1, id);
            ResultSet dataTable = sqlStatement.executeQuery();
            if (dataTable.next()) {
                return new Employee(
                        id,
                        dataTable.getString("Name"), 
                        dataTable.getDate("Date").toLocalDate(),
                        dataTable.getTime("Check_in").toLocalTime(),
                        dataTable.getTime("Check_out").toLocalTime(),
                        dataTable.getBigDecimal("Hours_Worked")
                    );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getidbyname(String name){
        throw new UnsupportedOperationException("Unimplemented method 'getidbyname'");
    }

    @Override
    public List<Employee> getAllemployees() {
        List<Employee> employeeList = new ArrayList<>();
        // SELECT * FROM account;
        try {
            Statement sqlStatement = sqlConnection.createStatement();
            ResultSet dataTable = sqlStatement.executeQuery("Select id, Name, Date, Check_in, Check_out, Hours_Worked from attendance");
            while (dataTable.next()) {
                employeeList.add(
                    new Employee(
                        dataTable.getInt("id"), 
                        dataTable.getString("name"), 
                        dataTable.getDate("date").toLocalDate(),
                        dataTable.getTime("check_in").toLocalTime(),
                        dataTable.getTime("check_out").toLocalTime(),
                        dataTable.getBigDecimal("hours_worked")
                    ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean deleteemployee(int id) {
        // DELETE FROM account WHERE number = ?;
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "DELETE FROM attendance WHERE id = ?");
            sqlStatement.setInt(1, id);
            return sqlStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }

    


