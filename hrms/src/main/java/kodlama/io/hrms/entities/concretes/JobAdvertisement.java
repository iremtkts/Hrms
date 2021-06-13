package kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class JobAdvertisement {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id ; 
	
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "min_salary")
	private int minSalary ;
	
	@Column(name="position_amount")
	private int positionAmount;
	
	@Column(name="application_deadline_date")
	private Date applicationDeadlineDate;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="is_active")
	private boolean isActive;

}
