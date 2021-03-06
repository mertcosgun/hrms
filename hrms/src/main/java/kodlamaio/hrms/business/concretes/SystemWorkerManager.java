package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerDao;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@Service
public class SystemWorkerManager implements SystemWorkerService {

	private SystemWorkerDao workerDao;

	@Autowired
	public SystemWorkerManager(SystemWorkerDao workerDao) {
		super();
		this.workerDao = workerDao;
	}

	@Override
	public Result add(SystemWorker systemWorker) {
		this.workerDao.save(systemWorker);
		return new SuccessResult("Çalışan sistemen başarıyla eklendi.");
	}

	@Override
	public DataResult<SystemWorker> getByEmail(String email) {
		return new SuccessDataResult<SystemWorker>(this.workerDao.getByEmail(email));
	}

	@Override
	public DataResult<List<SystemWorker>> getAll() {
		return new SuccessDataResult<List<SystemWorker>>(this.workerDao.findAll());
	}

}
