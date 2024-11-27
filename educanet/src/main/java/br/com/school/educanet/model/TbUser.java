package br.com.school.educanet.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 * 
 */
@Entity
@Table(name="tb_user")
@Data
public class TbUser {
	private String userName;
	private String userLastName;
	private String password;
	private String email;
	private String userCpf;
	private String userVerification;
	@Temporal(TemporalType.DATE)
	private Date userRegistation = new Date();
	
	@Id
	@GeneratedValue(strategy = GenerationType.	IDENTITY)
	private long userId ;



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserVerification() {
		return userVerification;
	}
	public void setUserVerification(String userVerification) {
		this.userVerification = userVerification;
	}
	public String getUserPassword() {
		return password;
	}
	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}
	public String getUserCpf() {
		return userCpf;
	}
	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUserRegistation() {
		return userRegistation;
	}
	public void setUserRegistation(Date userRegistation) {
		this.userRegistation = userRegistation;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}

