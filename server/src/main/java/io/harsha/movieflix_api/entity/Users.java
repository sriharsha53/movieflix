package io.harsha.movieflix_api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "SELECT e FROM Users e"),
		@NamedQuery(name = "Users.findByEmail", query = "SELECT e FROM Users e WHERE e.email=:uEmail"),
		@NamedQuery(name = "Users.findByType", query = "SELECT e FROM Users e WHERE e.roleType=:uType") })

public class Users {

	public enum RoleType {
		admin("Admin"), user("User");

		private String niceName;

		public String getNiceName() {
			return niceName;
		}

		private RoleType(String niceName) {
			this.niceName = niceName;
		}

	}

	@Id
	private String id;

	@Column(unique = true)
	private String email;

	private String userName;
	private String password;
	private RoleType roleType;

	public Users() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

}
