package spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.entity.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {
	@Query("select a from Company a where a.companyName like :companyName")
	public List<Company> findCompanyByCompanyName(@Param("companyName") String companyName);

	@Query("select a from Company a where a.estimatedEarnings = :estimatedEarnings")
	public List<Company> findCompanyByEstimatedEarnings(@Param("estimatedEarnings") double estimatedEarnings);
}
