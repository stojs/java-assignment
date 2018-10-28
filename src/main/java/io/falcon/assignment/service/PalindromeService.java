package io.falcon.assignment.service;

import java.util.List;

import io.falcon.assignment.domain.TestEntry;
import io.falcon.assignment.entity.Test;

public interface PalindromeService {

	void savePalindrome(String palindromeStr);
	List<TestEntry> getPalindromes();
	
	

}
