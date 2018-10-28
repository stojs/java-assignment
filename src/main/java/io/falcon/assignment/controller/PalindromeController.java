package io.falcon.assignment.controller;


import io.falcon.assignment.domain.TestEntry;
import io.falcon.assignment.service.PalindromeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

@RestController
@RequestMapping("app")
public class PalindromeController {
	
	@Autowired
    private PalindromeService palindromeService;

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
    public void savePalindrome(@RequestBody String palindromeStr) {
        palindromeService.savePalindrome(palindromeStr);
    	
    }
    
    
    @PostMapping("get")
    public List<TestEntry> get() {
        return palindromeService.getPalindromes();
    	
    }
   

}