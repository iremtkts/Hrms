package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes")

public class VerificationCode {
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id ;
	@Column(name="user_id")
	private int userId;
	@Column(name="code")
	private String verificationCode;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	

}

