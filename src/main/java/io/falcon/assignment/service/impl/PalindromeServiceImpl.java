package io.falcon.assignment.service.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.falcon.assignment.domain.TestEntry;
import io.falcon.assignment.entity.Test;
import io.falcon.assignment.repository.PalindromeRepository;
import io.falcon.assignment.service.PalindromeService;

@Service
public class PalindromeServiceImpl implements PalindromeService {
	
	@Autowired
	private PalindromeRepository palindromeRepository;
	
	@Override
	public void savePalindrome(String palindromeStr) {
		Test test = new Test(System.currentTimeMillis(),palindromeStr);
		palindromeRepository.save(test);	
	}

	@Override
	public List<TestEntry> getPalindromes() {
		List<Test> testList = palindromeRepository.findAll();
		List<TestEntry> testEntryList =  new ArrayList<>();
		for (Test test : testList) {
			int size = calculate_longest_palindrom(test.getText().toLowerCase());
			testEntryList.add(new TestEntry(new Timestamp(test.getId()),test.getText(),size));
		}
		
		return testEntryList;
	}

	
	private int calculate_longest_palindrom(String text) {
		 int right = 0, left = 0;
		 text=text.replaceAll("\\s+","");
	        String palindrome = "", longest = "";
	        for (int center = 1; center < text.length() - 1; center++) {
	            left = center - 1;  right = center + 1;
	            while (left >= 0 && right < text.length()) {
	                if (text.charAt(left) != text.charAt(right)) {
	                    break;
	                }
	                palindrome = text.substring(left, right + 1);
	                longest = palindrome.length() > longest.length() ? palindrome : longest;
	                left--;  right++;
	            }
	        }
	        return longest.length();
	}
	
	
	
	


}
