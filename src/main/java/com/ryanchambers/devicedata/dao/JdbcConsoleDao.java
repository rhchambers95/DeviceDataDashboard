package com.ryanchambers.devicedata.dao;

import com.ryanchambers.devicedata.model.Console;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Timestamp;

@Component
public class JdbcConsoleDao implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcConsoleDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Console console) {
        String sql = "INSERT INTO console_log (console_id, last_updated) VALUES (?, ?)";
        jdbcTemplate.update(sql, console.getId(), new Timestamp(System.currentTimeMillis()));
    }

}