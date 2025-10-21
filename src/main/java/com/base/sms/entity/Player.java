package com.base.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GalaxysInfo")
public class Player {
	@Id
	private Integer Id;
	@Column(name = "Name")
	private String name;
	private String email;

	private Integer age;

	private String position;
	
	 private String country;
	
	public Player() {
	}

    public Player(Integer id, String name, String email, Integer age, String position, String country) {
        super();
        this.Id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.position = position;
        this.country = country;
    }
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Player [Id=" + Id + ", name=" + name + ", email=" + email + ", age=" + age + ", position=" + position
                + ", country=" + country + "]";
    }
}
