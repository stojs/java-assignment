package io.falcon.assignment.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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
	public void savePalindrome(String palindromeStr,Long timeStamp) {
		Test test = new Test(timeStamp, palindromeStr);
		palindromeRepository.save(test);
	}

	@Override
	public List<TestEntry> getPalindromes() {
		List<Test> testList = palindromeRepository.findAll();
		List<TestEntry> testEntryList = new ArrayList<>();
		for (Test test : testList) {
			int size = calculate_longest_palindrom(test.getText().toLowerCase());
			testEntryList.add(new TestEntry(new Timestamp(test.getId()), test.getText(), size));
		}

		return testEntryList;
	}

	private int calculate_longest_palindrom(String text) {
		String pipe = "|";
		text = text.replaceAll("\\s+", "");
		StringBuilder sb = new StringBuilder(pipe);

		for (char c : text.toCharArray()) {
			sb.append(c).append(pipe);
		}
		
		String t = sb.toString();
		int size = t.length();
		int[] result = new int[size];
		int center = 1;
		int right = 2;

		for (int i = 1; i < size - 1; i++) {
			int i_mirror = 2 * center - i;
			result[i] = (i < right) ? Math.min(right - i, result[i_mirror]) : 0;
			while (i - 1 - result[i] >= 0 && i + 1 + result[i] < size
					&& t.charAt(i + 1 + result[i]) == t.charAt(i - 1 - result[i])) {
				result[i]++;
			}
			if (i + result[i] > right) {
				center = i;
				right = i + result[i];
			}
		}
		
		int centerIndex = largestElement(result);
		int maxLen = result[centerIndex];
		int start = (centerIndex - maxLen) / 2;
		int end = start + maxLen;

		return text.substring(start, end).length();
	}

	private int largestElement(int[] r) {
		int max = 0;
		int index = 0;

		for (int i = 0; i < r.length; i++) {
			if (r[i] > max) {
				max = r[i];
				index = i;
			}
		}
		return index;
	}

}
