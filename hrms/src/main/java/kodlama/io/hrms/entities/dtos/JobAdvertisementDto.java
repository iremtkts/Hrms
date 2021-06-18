package kodlama.io.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private int id ;
	private String companyName;
	private String positionName;
	private int positionAmount;
	private Date releaseDate;
	private Date applicationDeadline;
	private String jobDescription;
	private int minSalary ;
	private int maxSalary;

}



