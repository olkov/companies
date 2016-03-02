package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.entity.Company;
import spring.service.CompanyService;
import spring.service.impl.TreeService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private TreeService treeService;

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String company(@RequestParam(value = "id") String idCompany, Model model) {
		Company company = new Company();
		Company company2 = new Company();
		try {
			company = companyService.getCompanyById(idCompany);
			if (company != null && company.getParentId() != null) {
				company2 = companyService.getCompanyById(String.valueOf(company.getParentId()));
			}
		} catch (Exception e) {
			System.out.println(e + "\n");
		}
		model.addAttribute("company", company);
		model.addAttribute("company2", company2);
		return "company";
	}

	@RequestMapping(value = { "/", "companies" })
	public String homePage(Model model) {
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
		model.addAttribute("companies", json);
		return "companies";
	}

	@RequestMapping(value = "/addCompany")
	public String addCompany(Model model) {
		return "add company";
	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String addCompany(Model model, @RequestParam("companyName") String companyName,
			@RequestParam("estimatedEarnings") String estimatedEarnings) {
		companyService.insertCompany(companyName, estimatedEarnings);
		return "redirect:/";
	}

	@RequestMapping(value = "/addChildCompany")
	public String addChildCompany(@RequestParam(value = "id") String id, Model model) {
		Company company = new Company();
		try {
			company = companyService.getCompanyById(id);
		} catch (Exception e) {
			System.out.println(e + "\n");
		}
		model.addAttribute("id", id);
		model.addAttribute("company", company);
		return "add child company";
	}

	@RequestMapping(value = "/addChildCompany", method = RequestMethod.POST)
	public String addChildCompany(Model model, @RequestParam("companyName") String companyName,
			@RequestParam("estimatedEarnings") String estimatedEarnings, @RequestParam(value = "id") String id) {
		companyService.insertCompany(companyName, estimatedEarnings, id);
		return "redirect:/company?id=" + id;
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.GET)
	public String updateCompany(Model model, @RequestParam(value = "id") String id) {
		try {
			model.addAttribute("company", companyService.getCompanyById(id));
		} catch (Exception e) {
			System.out.println(e + "\n");
		}
		return "update company";
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public String updateCompany(Model model, @RequestParam("companyName") String companyName,
			@RequestParam("estimatedEarnings") String estimatedEarnings, @RequestParam(value = "id") String idCompany,
			@RequestParam(value = "parentId") String parentId) {
		companyService.updateCompany(idCompany, companyName, estimatedEarnings, parentId);
		return "redirect:/company?id=" + idCompany;
	}

	@RequestMapping(value = "/removeCompany", method = RequestMethod.GET)
	public String removeCompany(Model model, @RequestParam(value = "id") String idCompany) {
		treeService.removeTreeCompaniesById(idCompany);
		return "redirect:/";
	}
}
