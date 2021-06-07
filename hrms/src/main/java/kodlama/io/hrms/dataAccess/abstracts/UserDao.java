package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	boolean existsByEmailAdress(String email);
}
