package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.KnownTechnology;

public interface KnownTechnologyDao extends JpaRepository<KnownTechnology, Integer> {
	
	List<KnownTechnology> getByResumeId(int resumeId);

}
