package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownLanguageDao;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@Service
public class KnownLanguageManager implements KnownLanguageService {
	
	
	private KnownLanguageDao knownLanguageDao;
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
	}

	@Override
	public Result add(KnownLanguage knownLanguage) {
		this.knownLanguageDao.save(knownLanguage);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<KnownLanguage> getByJobSeeker(int jobSeekerId) {
		return new SuccessDataResult<KnownLanguage>(this.knownLanguageDao.findByJobSeeker(jobSeekerId), "Başarıyla getirildi.");
	}

	@Override
	public Result delete(int id) {
		this.knownLanguageDao.deleteById(id);
		return new SuccessResult("Silme işlemei başarıyla gerçekleştirildi.");
	}

}
