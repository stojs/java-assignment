package io.falcon.assignment.domain;

import java.sql.Timestamp;

public class TestEntry {
	private Timestamp timestamp;
	private String  content;
	private  int size;
	
	public TestEntry(Timestamp timestamp, String content, int size) {
		super();
		this.timestamp = timestamp;
		this.content = content;
		this.size = size;
	}
	
	public TestEntry(Timestamp timestamp, String content) {
		super();
		this.timestamp = timestamp;
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "TestEntry [timestamp=" + timestamp + ", content=" + content + ", size=" + size + "]";
	}
	
	

}
