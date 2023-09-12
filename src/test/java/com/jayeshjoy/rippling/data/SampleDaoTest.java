package com.jayeshjoy.rippling.data;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SampleDaoTest {
    public static class BeanPropertyRowMapperMatcher implements ArgumentMatcher<BeanPropertyRowMapper<Temp>> {
        private BeanPropertyRowMapper<Temp> left;

        public BeanPropertyRowMapperMatcher(BeanPropertyRowMapper<Temp> left) {
            this.left = left;
        }

        @Override
        public boolean matches(BeanPropertyRowMapper<Temp> right) {
            return left.getMappedClass().equals(right.getMappedClass());
        }
    }

    @Test
    public void getAllTemps() {
        String expectedQuery =
                "SELECT * FROM TEMP ORDER BY Name LIMIT ? OFFSET ?";
        int limit = 10;
        int offset = 12;
        Temp temp = new Temp(
                UUID.randomUUID(),
                "test name",
                Date.valueOf("1992-01-01"),
                1);
        BeanPropertyRowMapper<Temp> beanPropertyRowMapper =
                new BeanPropertyRowMapper<>(Temp.class);
        ImmutableList<Temp> expected = ImmutableList.of(temp);
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.query(
                eq(expectedQuery),
                argThat(new BeanPropertyRowMapperMatcher(beanPropertyRowMapper)),
                eq(limit),
                eq(offset))).thenReturn(expected);
        SampleDao sampleDao = new SampleDao(jdbcTemplate);

        List<Temp> result = sampleDao.getAllTemps(limit, offset);

        assertEquals(expected, result);
    }
}