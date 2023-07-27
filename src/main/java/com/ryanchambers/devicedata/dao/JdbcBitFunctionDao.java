package com.ryanchambers.devicedata.dao;

import com.ryanchambers.devicedata.model.BitFunction;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcBitFunctionDao implements BitFunctionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBitFunctionDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BitFunction> getAll() {

        return null;
    }

    @Override
    public void create(BitFunction bitFunction) {

    }
}
