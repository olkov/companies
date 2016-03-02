package spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompany;
	private String companyName;
	private double estimatedEarnings;
	private Long parentId;

	public Company() {
	}

	public Company(String companyName, double estimatedEarnings) {
		this.companyName = companyName;
		this.estimatedEarnings = estimatedEarnings;
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getEstimatedEarnings() {
		return estimatedEarnings;
	}

	public void setEstimatedEarnings(double estimatedEarnings) {
		this.estimatedEarnings = estimatedEarnings;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Company [idCompany=" + idCompany + ", companyName=" + companyName + ", estimatedEarnings="
				+ estimatedEarnings + ", parentId=" + parentId + "]";
	}
}
