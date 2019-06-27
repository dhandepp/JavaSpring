package SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SpringPGRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
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
}
