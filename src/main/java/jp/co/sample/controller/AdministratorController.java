package jp.co.sample.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	private AdministratorService service;
	//private NamedParameterJdbcTemplate template;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm adform = new InsertAdministratorForm();
		return adform;		
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "/administrator/insert.html";
	}
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form, Model model) {
		Administrator ad =new Administrator();
		ad.setName(form.getName());
		ad.setMailAdress(form.getMailAddress());
		ad.setPassword(form.getPassword());
		administratorService.insert(ad);
		model.addAttribute("ad", ad);
		return "/";	
	}
}
