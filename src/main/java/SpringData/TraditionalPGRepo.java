package SpringData;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TraditionalPGRepo {
    final String CONN_STRING = "org.postgresql.Driver";
    final String DB_PATH = "jdbc:postgresql://localhost/ei";
    final String USER_NAME = "postgres";
    final String PWD = "root";

    Connection conn;
    public TraditionalPGRepo(){
        try {
            Class.forName(CONN_STRING).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_PATH,USER_NAME,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> list(){
        List employees = new ArrayList();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPractice(rs.getString("practice"));
                employee.setProject(rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
