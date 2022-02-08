package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		UpdateEmployeeForm employeeForm = new UpdateEmployeeForm();
		return employeeForm;
	}

	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Employee employee = employeeService.showDetail(id);
		model.addAttribute("employee", employee);
		return "employee/detail.html";

	}

}