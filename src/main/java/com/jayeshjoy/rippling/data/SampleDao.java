package com.jayeshjoy.rippling.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SampleDao {
    final private static String GET_ALL_TEMPS =
            "SELECT * FROM TEMP ORDER BY Name LIMIT ? OFFSET ?";
    final private static String CREATE_TEMP =
            "REPLACE INTO TEMP (ID, Name,Birth_date, Titles) " +
                    "VALUES (?, ?, ?, ?)";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public SampleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable("allTempsCache")
    public List<Temp> getAllTemps(int limit, int offset) {
        return jdbcTemplate.query(
                GET_ALL_TEMPS,
                new BeanPropertyRowMapper<>(Temp.class),
                limit,
                offset);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "allTempsCache", allEntries = true),
            @CacheEvict(value = "TempCache", key = "#temp.getId()")
    })
    public int createTemp(Temp temp) {
        return jdbcTemplate.update(
                CREATE_TEMP,
                temp.getId(),
                temp.getName(),
                temp.getBirthDate().toLocalDate().atStartOfDay(),
                temp.getTitles());
    }

    @Async("asyncExecutor")
    @Caching(evict = {
            @CacheEvict(value = "allTempsCache", allEntries = true),
            @CacheEvict(value = "TempCache", key = "#temp.getId()")
    })
    public CompletableFuture<Integer> createTempAsync(Temp temp) {
        return CompletableFuture.completedFuture(createTemp(temp));
    }
}
