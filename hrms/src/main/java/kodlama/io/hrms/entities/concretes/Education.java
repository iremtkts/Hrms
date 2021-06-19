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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JoinColumn(name="cv_id" )
	private Cv cv;
	
	@NotBlank(message="okul adı alanı boş bırakılamaz")
	@Column(name="university_name")
	private String universityName;
	
	@NotBlank(message="bölüm adı alanı boş bırakılamaz")
	@Column(name="university_department_name")
	private String universityDepartmentName;

}
