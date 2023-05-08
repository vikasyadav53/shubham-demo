package com.example.demo.models;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 7156526077883281623L;

    private Long id;
    private String name;
    private long followers;

    public User() {
    }

    public User(String name, long followers) {
        this.name = name;
        this.followers = followers;
    }
   
    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}

}
