
package com.argprograma.portfolio.Modelo;

import java.io.Serializable;
import javax.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "user")
public class DAOUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}