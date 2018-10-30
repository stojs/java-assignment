package io.falcon.assignment.service;

import io.falcon.assignment.model.TestModel;
import java.util.List;

public interface PalindromeService {

    void savePalindrome(String palindromeStr, Long timeStamp);

    List<TestModel> getPalindromes();
}
