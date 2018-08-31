package com.nagarro.model;

public class Image {
	private int id;
	private String username;
	private byte[] image = null;

	public Image() {
	}

	public Image(int size) {
		image = new byte[size];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
