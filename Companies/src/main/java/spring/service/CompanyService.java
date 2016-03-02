package spring.service;

import java.util.List;

import spring.entity.Company;

public interface CompanyService {
	public void insertCompany(Company company);

	public void insertCompany(String companyName, String estimatedEarnings);
	
	public void insertCompany(String companyName, String estimatedEarnings, String parentId);

	public void updateCompany(String idCompany, String companyName, String estimatedEarnings, String parentId);

	public void removeCompanyById(String idCompany);

	public void removeCompany(Company company);

	public List<Company> getAllCompanies();

	public Company getCompanyById(String idCompany);

	public Company getCompanyById(int idCompany);

	public Company isRootCompany(int idCompany);
	
	public List<Company> getAllRootCompanies();

	public List<Company> getCompanyByParentId(int id);

	public List<Company> getCompanyByCompanyName(String companyName);

	public List<Company> getCompanyByEstimatedEarnings(double estimatedEarnings);
}
