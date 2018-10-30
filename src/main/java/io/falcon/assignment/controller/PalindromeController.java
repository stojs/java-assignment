package io.falcon.assignment.controller;

import io.falcon.assignment.model.TestModel;
import io.falcon.assignment.service.PalindromeService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

@RestController
@RequestMapping("app")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;
    public HttpStatus statusCode;

    @PostMapping("/add")
    public ResponseEntity<Void> savePalindrome(@RequestBody TestModel test) {
        String palindromeStr = test.getContent();
        Long timeStamp = test.getTimestamp();
        Pattern p = Pattern.compile("^[ A-Za-z]+$");
        Matcher matcher = p.matcher(palindromeStr);
        if (matcher.matches()) {
            palindromeService.savePalindrome(palindromeStr, timeStamp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get")
    public List<TestModel> get() {
        return palindromeService.getPalindromes();

    }

}
