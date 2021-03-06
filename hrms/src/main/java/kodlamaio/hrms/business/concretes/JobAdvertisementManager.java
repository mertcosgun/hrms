package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementSaveDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;
	
	private ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	// private ModelMapperService mapperService;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(JobAdvertisementSaveDto advertisementSaveDto) {
		JobAdvertisement advertisement = getModelMapper().map(advertisementSaveDto, JobAdvertisement.class);

		getModelMapper().map(this.advertisementDao.save(advertisement), JobAdvertisementSaveDto.class);
		return new SuccessResult("Başarıyla Ekelendi.");
	}

	/*@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findAll());
	}
*/
	@Override
	public DataResult<JobAdvertisementDetailDto> getByJobAdvertisement_Id(int id) {
		JobAdvertisement advertisement = this.advertisementDao.getByJobAdvertisement_Id(id);
		
		JobAdvertisementDetailDto advertisementDetailDto = getModelMapper().map(advertisement, JobAdvertisementDetailDto.class);
		return new SuccessDataResult<JobAdvertisementDetailDto>(advertisementDetailDto);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.getByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getBySortedDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.getByIsActiveAndSortedDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(boolean isActive,
			String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.advertisementDao.getByIsActiveAndEmployer_CompanyName(isActive, companyName));
	}

	@Override
	public Result update(JobAdvertisementSaveDto advertisementSaveDto) {
		//modelMapper = new ModelMapper();
		JobAdvertisement advertisement = getModelMapper().map(advertisementSaveDto, JobAdvertisement.class);

		getModelMapper().map(this.advertisementDao.save(advertisement), JobAdvertisementSaveDto.class);

		// JobAdvertisement
		return new SuccessResult(advertisementSaveDto.getId() + "'li iş ilanı kapatıldı.");
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAll() {
		//modelMapper = new ModelMapper();

		List<JobAdvertisement> advertisements = this.advertisementDao.findAll();

		List<JobAdvertisementDetailDto> advertisementDetailDto = advertisements.stream()
				.map(advertisement -> getModelMapper().map(advertisement, JobAdvertisementDetailDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(advertisementDetailDto);
	}

}
