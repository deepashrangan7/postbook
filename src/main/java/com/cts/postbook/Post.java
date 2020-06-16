package com.cts.postbook;

public class Post {

	public Post(int id, String body, String title) {
		super();
		this.id = id;
		this.body = body;
		this.title = title;
	}

	public Post() {
		super();
	}

	private int id;
	private String body;
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", body=" + body + ", title=" + title + "]";
	}

}
