package spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.Company;
import spring.service.CompanyService;
import spring.tree.CompanyTree;
import spring.tree.Node;

@Service
public class TreeService {
	@Autowired
	private CompanyService companyService;
	double sum = 0;
	double sum2 = 0;

	public TreeService() {
	}

	private void calc(List<Node<Company>> children) {
		for (Node<Company> node : children) {
			sum += node.getData().getEstimatedEarnings();
			calc(node.getChildren());
		}
	}

	public String cbBTreeAsJson(final CompanyTree tree) {
		final StringBuffer sb = new StringBuffer();
		final Company root = tree.getRootElement().getData();
		calc(tree.getRootElement().getChildren());
		if (sum != 0) {
			sb.append("{\"key\": \"" + root.getIdCompany() + "\", \"title\": \"" + root.getCompanyName() + " | "
					+ root.getEstimatedEarnings() + "K$ | " + (sum + root.getEstimatedEarnings())
					+ "K$ |\", \"href\": \"" + "#/company/" + root.getIdCompany() + "\", \"children\": [\r");
		} else {
			sb.append("{\"key\": \"" + root.getIdCompany() + "\", \"title\": \"" + root.getCompanyName() + " | "
					+ root.getEstimatedEarnings() + "K$ |\", \"href\": \"" + "#/company/" + root.getIdCompany()
					+ "\", \"children\": [\r");
		}
		final List<Node<Company>> children = tree.getRootElement().getChildren();
		loopForChildren(sb, children);
		sb.append("]");
		sum = 0;
		return sb.toString();
	}

	private void calc2(List<Node<Company>> children) {
		for (Node<Company> node : children) {
			sum2 += node.getData().getEstimatedEarnings();
			calc2(node.getChildren());
		}
	}

	private StringBuffer loopForChildren(final StringBuffer sb, final List<Node<Company>> children) {
		calc2(children);
		for (int i = 0; i < children.size(); i++) {
			final Node<Company> childElement = children.get(i);
			if (i == 0) {
				if (sum2 == 0 || !childElement.hasChildren()) {
					sb.append("{\"key\": \"" + childElement.getData().getIdCompany() + "\", \"title\": \""
							+ childElement.getData().getCompanyName() + " | "
							+ childElement.getData().getEstimatedEarnings() + "K$ |\", \"href\": \"" + "#/company/"
							+ childElement.getData().getIdCompany() + "\"");
				} else {
					sb.append("{\"key\": \"" + childElement.getData().getIdCompany() + "\", \"title\": \""
							+ childElement.getData().getCompanyName() + " | "
							+ childElement.getData().getEstimatedEarnings() + "K$ | " + sum2 + " |\", \"href\": \""
							+ "#/company/" + childElement.getData().getIdCompany() + "\"");
				}
			} else {
				if (sum2 == 0) {
					sb.append(", {\"key\": \"" + childElement.getData().getIdCompany() + "\", \"title\": \""
							+ childElement.getData().getCompanyName() + " | "
							+ childElement.getData().getEstimatedEarnings() + "K$ |\", \"href\": \"" + "#/company/"
							+ childElement.getData().getIdCompany() + "\"");
				} else {
					sb.append(", {\"key\": \"" + childElement.getData().getIdCompany() + "\", \"title\": \""
							+ childElement.getData().getCompanyName() + " | "
							+ childElement.getData().getEstimatedEarnings() + "K$ | " + sum2 + " |\", \"href\": \""
							+ "#/company/" + childElement.getData().getIdCompany() + "\"");
				}
			}
			sum2 = 0;
			if (childElement.hasChildren()) {
				sb.append(", \"children\": [\r");
				loopForChildren(sb, childElement.getChildren());
			} else {
				sb.append("}");
			}
		}
		sb.append("]}");
		return sb;
	}

	@Transactional
	public CompanyTree get(int id) {
		final CompanyTree tree = new CompanyTree();
		Node<Company> root = new Node<Company>(companyService.isRootCompany(id));
		getRecursive(root, tree);
		tree.setRootElement(root);
		return tree;
	}

	@Transactional
	private void getRecursive(final Node<Company> company, final CompanyTree tree) {
		final List<Company> children = companyService.getCompanyByParentId(company.getData().getIdCompany());
		final List<Node<Company>> childElements = new ArrayList<Node<Company>>();
		for (final Company childCompany : children) {
			final Node<Company> childElement = new Node<Company>(childCompany);
			childElements.add(childElement);
			getRecursive(childElement, tree);
		}
		company.setChildren(childElements);
	}

	public void removeTreeCompaniesById(String idCompany) {
		try {
			companyService.removeCompanyById(idCompany);
			for (Company company : companyService.getCompanyByParentId(Integer.parseInt(idCompany))) {
				removeTreeCompaniesById(String.valueOf(company.getIdCompany()));
			}
		} catch (Exception e) {
			System.out.println(e + "\n");
		}
	}
}
