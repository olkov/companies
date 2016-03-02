package spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CompanyDao;
import spring.entity.Company;
import spring.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Transactional
	public void insertCompany(Company company) {
		companyDao.save(company);
	}

	@Transactional
	public void insertCompany(String companyName, String estimatedEarnings) {
		try {
			Company company = new Company();
			if (estimatedEarnings.compareTo("") != 0) {
				company.setEstimatedEarnings(Double.parseDouble(estimatedEarnings));
			}
			if (companyName.compareTo("") != 0) {
				company.setCompanyName(companyName);
			}
			companyDao.save(company);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error " + e + " in CompanyService(insertCompany)!");
		}
	}

	public void insertCompany(String companyName, String estimatedEarnings, String parentId) {
		try {
			Company company = new Company();
			if (estimatedEarnings.compareTo("") != 0) {
				company.setEstimatedEarnings(Double.parseDouble(estimatedEarnings));
			}
			if (companyName.compareTo("") != 0) {
				company.setCompanyName(companyName);
			}
			if (parentId.compareTo("") != 0) {
				company.setParentId(Long.parseLong(parentId));
			}
			companyDao.save(company);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error " + e + " in CompanyService(insertCompany)!");
		}
	}

	@Transactional
	public void updateCompany(String idCompany, String companyName, String estimatedEarnings, String parentId) {
		Company company = new Company();
		try {
			company.setIdCompany(Integer.parseInt(idCompany));
			company.setCompanyName(companyName);
			company.setEstimatedEarnings(Double.parseDouble(estimatedEarnings));
			if (parentId.compareTo("") != 0) {
				company.setParentId(Long.parseLong(parentId));
			}
		} catch (Exception e) {
			System.out.println(e + "\n");
		}
		companyDao.save(company);
	}

	@Transactional
	public void removeCompanyById(String idCompany) {
		try {
			if (idCompany.compareTo("") != 0) {
				companyDao.delete(Integer.parseInt(idCompany));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e + "\nError in CompanyService(removeCompanyById)!");
		}
	}

	@Transactional
	public void removeCompany(Company company) {
		try {
			companyDao.delete(company);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e + "\nError in CompanyService(removeCompany)!");
		}
	}

	@Transactional
	public List<Company> getAllCompanies() {
		return companyDao.findAll();
	}

	@Transactional
	public Company getCompanyById(String idCompany) {
		try {
			if (idCompany.compareTo("") != 0) {
				return companyDao.findOne(Integer.parseInt(idCompany));
			}
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.out.println(e + " in CompanyService(getCompanyById)!");
		}
		return null;
	}

	@Transactional
	public Company getCompanyById(int idCompany) {
		return companyDao.findOne(idCompany);
	}

	@Transactional
	public Company isRootCompany(int idCompany) {
		try {
			Company company = getCompanyById(idCompany);
			if (company.getParentId() == null) {
				return company;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e + " in CompanyService(getRootCompany)!");
		}
		return null;
	}

	@Transactional
	public List<Company> getAllRootCompanies() {
		List<Company> companies = new ArrayList<Company>();
		try {
			for (Company company : getAllCompanies()) {
				if (company.getParentId() == null) {
					companies.add(company);
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e + " in CompanyService(getAllRootCompanies)!");
		}
		return companies;
	}

	@Transactional
	public List<Company> getCompanyByParentId(int id) {
		List<Company> companies = new ArrayList<Company>();
		try {
			for (Company company : getAllCompanies()) {
				if (company.getParentId() != null && company.getParentId() == id) {
					companies.add(company);
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e + " in CompanyService(getCompanyByParentId)!");
		}
		return companies;
	}

	@Transactional
	public List<Company> getCompanyByCompanyName(String companyName) {
		return companyDao.findCompanyByCompanyName(companyName);
	}

	@Transactional
	public List<Company> getCompanyByEstimatedEarnings(double estimatedEarnings) {
		return companyDao.findCompanyByEstimatedEarnings(estimatedEarnings);
	}
}
