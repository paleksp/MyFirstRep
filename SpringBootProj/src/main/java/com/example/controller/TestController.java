package com.example.controller;

import com.example.model.NVHead;
import com.example.model.NVCumDue;
import com.example.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TestController {
    private final HeadService headService;

    @Autowired
    public TestController(HeadService headService) {
        this.headService = headService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello, " + name;
    }

    // Комментарий тест, может быть ошибка
    @GetMapping("/newEntry")
    public NVHead newEntry() {

        return headService.addNewEntry();
    }
}
