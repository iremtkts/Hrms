package kodlama.io.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")



public class Employer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="website_adress")
	@NotNull
	private String websiteAdress;
	@Column(name="company_name")
	@NotNull
	private String companyName;
	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;

}
