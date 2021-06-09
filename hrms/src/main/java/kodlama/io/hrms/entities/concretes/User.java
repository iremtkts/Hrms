package kodlama.io.hrms.entities.concretes;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Email
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Inheritance( strategy = InheritanceType.JOINED)

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	
	@NotBlank()
	@Column(name="id")
	private int id ;
	
	@Email(message = "Geçerli bir mail adresi giriniz")
	@NotBlank(message = "Email Alanı Boş Bırakılamaz")
	@Column(name="email")
	private String email;
	
	@NotBlank(message = "Şifre Alanı Boş Bırakılamaz")
	@Size(min=6, max=16, message="Şifre en az 6, en fazla 16 karakterden oluşabilir")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Şifre Alanı Boş olamaz")
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password")
    private String passwordRepeat;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="is_active" , columnDefinition = "boolean default true")
    private boolean isActive;
	

}
