package io.falcon.assignment.service;

import java.util.List;

import io.falcon.assignment.domain.TestEntry;
import io.falcon.assignment.entity.Test;

public interface PalindromeService {

	void savePalindrome(String palindromeStr,Long timeStamp);
	List<TestEntry> getPalindromes();
	
	

}
