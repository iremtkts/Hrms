package kodlama.io.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerWithJobPositionDto {
	
	private int id ;
	private String companyName;
	private String positionName;
	private int positionAmount;
	private Date releaseDate;
	private Date applicationDeadline;

}
