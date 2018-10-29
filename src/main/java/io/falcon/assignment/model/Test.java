package io.falcon.assignment.model;

public class Test {

	private Long timestamp;
	private String content;
	
	public Test(Long timestamp, String content) {
		this.timestamp = timestamp;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Test [timestamp=" + timestamp + ", content=" + content + "]";
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
