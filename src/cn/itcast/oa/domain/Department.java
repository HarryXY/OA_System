package cn.itcast.oa.domain;

import java.util.Set;

public class Department {
	public Long id;
	public String name;
	public String description;
	public Set<User> User;
	public Department parent;
	public Set<Department> children;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUser() {
		return User;
	}
	public void setUser(Set<User> user) {
		User = user;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
}
