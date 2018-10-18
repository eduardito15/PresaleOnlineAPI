package com.presaleonline.presaleonlineapi.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String email;

	private String password;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;

	private String userType;

	public User() {
		roles = new ArrayList<>();
	}

	public User(String name, String password, List<Role> roles) {
		this.name = name;
		this.password = password;
		this.roles = new ArrayList<>();
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		return authorities;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if (!(obj instanceof User)) return false;
		else return ((User)obj).getId() == this.getId();
	}
}


