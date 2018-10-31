/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.falcon.assignment.controller;

import io.falcon.assignment.model.TestModel;
import io.falcon.assignment.service.impl.PalindromeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.hamcrest.Matchers.*;
import org.hamcrest.CoreMatchers;
import static org.mockito.Mockito.when;

/**
 *
 * @author Korisnik
 */
@RunWith(MockitoJUnitRunner.class)
public class PalindromeControllerTest {

    @Mock
    PalindromeServiceImpl palindromeServiceImpl;
    @InjectMocks
    PalindromeController palindromeController = new PalindromeController();

    public PalindromeControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of savePalindrome method, of class PalindromeController.
     */
    @Test
    public void testSavePalindrome() {
        System.out.println("savePalindrome");
        TestModel test = new TestModel(new Date().getTime(), "abrakadabra", 0);
        ResponseEntity<Void> result = palindromeController.savePalindrome(test);
        assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
    }
    
    
    @Test
    public void testSavePalindromeNotGoodPayload() {
        System.out.println("savePalindrome");
        TestModel test = new TestModel(new Date().getTime(), "abrak11adabra", 0);
        ResponseEntity<Void> result = palindromeController.savePalindrome(test);
        assertThat(result.getStatusCode(), equalTo(HttpStatus.CONFLICT));
    }

    /**
     * Test of get method, of class PalindromeController.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        List<TestModel> result = new ArrayList<TestModel>();
        TestModel test = new TestModel(new Date().getTime(), "abrakadabra", 0);
        result.add(test);
        when(palindromeServiceImpl.getPalindromes()).thenReturn(result);
        result = palindromeController.get();
        System.out.println("result" + result);
        assertTrue(result.contains(test));

    }

}
