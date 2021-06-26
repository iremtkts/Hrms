package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_time_types" )
@JsonIgnoreProperties({"hibernateLaztInitializer" , "handler" , "jobAdvertisement"})
public class WorkTimeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_time_type_id")
	private int workTimeTypeId;
	
	@Column(name="work_time_type_name")
	private String workTimeTypeName;
	
	@OneToMany(mappedBy="workTimeType")
	private List <JobAdvertisement> jobAdvertisement;

}
