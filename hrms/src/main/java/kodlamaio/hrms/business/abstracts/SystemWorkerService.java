package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemWorker;

public interface SystemWorkerService {

	Result add(SystemWorker systemWorker);

	DataResult<SystemWorker> getByEmail(String email);

	DataResult<List<SystemWorker>> getAll();

}
