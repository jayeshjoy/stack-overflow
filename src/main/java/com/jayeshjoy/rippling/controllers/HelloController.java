package com.jayeshjoy.rippling.controllers;

import com.jayeshjoy.rippling.data.SampleDao;
import com.jayeshjoy.rippling.data.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class HelloController {
    final SampleDao sampleDao;

    @Autowired
    public HelloController(SampleDao sampleDao) {
        this.sampleDao = sampleDao;
    }

    @GetMapping("/v1/hello")
    public String hello() {
        return "Hello, world";
    }

    @GetMapping("/v1/error")
    public String error() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error");
    }

    @GetMapping("/v1/allTemps")
    public List<Temp> getAllTemps(
            @RequestParam(value = "o", defaultValue = "0") int offset,
            @RequestParam(value = "psize", defaultValue = "10") int pageSize) {
        return sampleDao.getAllTemps(pageSize, offset);
    }

    @PutMapping("/v1/temp")
    public String putTemp(@RequestBody Temp temp) {
        try {
            sampleDao.createTemp(temp);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    exception.getMessage(), exception.getCause());
        }
        return "Successfully updated temp.";
    }
}
