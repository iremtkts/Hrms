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
@Table(name="system_personnel")
public class SystemPersonnel extends User {
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id ;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;

}
