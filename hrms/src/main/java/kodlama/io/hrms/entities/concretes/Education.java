package kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class Education {
	@Id
	@Column(name="education_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	
	@Column(name = "starting_date")
	private Date startingDate;
	
	@Column(name = "ending_date")
	private Date endingDate;
	
	@ManyToOne(targetEntity=Cv.class)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinColumn(name="cv_id" )
	private Cv cv;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	private School school;
	
	
	@ManyToOne()
	@JoinColumn(name="school_department_id")
	private SchoolDepartment schoolDepartment;
	
	
	
	
	
}
