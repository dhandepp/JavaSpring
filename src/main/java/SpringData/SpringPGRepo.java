package SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SpringPGRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    Connection conn;

    public List<Employee> list() {
        return null;
    }

    public int employeeCount() {
        String query = "select count(*) from employee";
        // second argument is array of object specifying the placeholders in sql query, like prepared statement
        // for returning custom type, need a rowmapper
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public Employee retrieve(int id) {
        String query = "select * from employee where id = '" + id + "'";
        return jdbcTemplate.queryForObject(query, new EmployeeMapper());
    }

    public int create(Employee employee){
        // Traditional JDBC template
      /*  String query = "insert into employee(name,project,practice) values ('"+employee.getName()+"','"+employee.getProject()+"','"+employee.getPractice()+"')";
        // If select query is run for update, returns PSQLException saying A RESULT WAS RETURNED WHEN NONE EXPECTED
        return jdbcTemplate.update(query);*/

      // Using NamedParameterJDBCTemplate
      String query = "insert into employee(name,project,practice) values (:name,:project,:practice)";
        SqlParameterSource source = new MapSqlParameterSource("name",employee.getName())
                .addValue("project",employee.getProject())
                .addValue("practice",employee.getPractice());

        try{}
        catch (Exception ex){
            // trigger rollback programmatically
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return namedJdbcTemplate.update(query,source);
    }

    // For DDL, use jdbcTemplate.execute(sql)
    // For DML, use queryFor..() or update()
}
