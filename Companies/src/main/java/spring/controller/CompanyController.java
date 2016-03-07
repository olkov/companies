package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.entity.Company;
import spring.service.CompanyService;
import spring.service.impl.TreeService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private TreeService treeService;

	@RequestMapping(value = { "/c" })
	@ResponseBody
	public String companies() {
		String json = "";
		for (Company company : companyService.getAllRootCompanies()) {
			String str = treeService.cbBTreeAsJson(treeService.get(company.getIdCompany()));
			str = str.substring(str.indexOf("{"), str.length() - 1);
			str += ", ";
			json += str;
		}
		if (!json.isEmpty()) {
			json = json.substring(0, json.lastIndexOf(", "));
			json = "[" + json + "]";
		}
		// System.out.println("json:\n" + json);
		return json;
	}

	@RequestMapping(value = "/addCompany")
	public String addCompany() {
		return "add company";
	}

	@RequestMapping("/saveCompany")
	@ResponseBody
	public void saveCompany(@RequestBody Company company) {
		companyService.insertCompany(company);
	}

	@RequestMapping(value = "/addChildCompany")
	public String addChildCompany() {
		return "add child company";
	}

	@RequestMapping(value = { "/all" })
	public String list() {
		return "all";
	}

	@RequestMapping("/getall")
	@ResponseBody
	public List<Company> all() {
		return this.companyService.getAllCompanies();
	}

	@RequestMapping(value = "/company")
	public String company() {
		return "company";
	}

	@RequestMapping("/getbyid")
	@ResponseBody
	public Company getById(int id) {
		return companyService.getCompanyById(id);
	}

	@RequestMapping("/removeCompany")
	@ResponseBody
	public void removeCompany(int id) {
		treeService.removeTreeCompaniesById(String.valueOf(id));
	}

	@RequestMapping(value = "/updateCompany")
	public String updateCompany() {
		return "update company";
	}
}
