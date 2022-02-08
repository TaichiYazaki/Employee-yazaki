package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm adform = new InsertAdministratorForm();
		return adform;
	}

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "/administrator/insert";
	}

	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form, Model model) {
		Administrator ad = new Administrator();
		ad.setName(form.getName());
		ad.setMailAdress(form.getMailAddress());
		ad.setPassword(form.getPassword());
		administratorService.insert(ad);
		model.addAttribute("ad", ad);
		return "/";
	}

	// ログインフォームのメソッド
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}

	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	@Autowired
	private HttpSession session;

	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator ad2 = administratorService.login(form.getMailAddress(), form.getPassword());
		if (ad2 == null) {
			model.addAttribute("error", "メールアドレスまたはpassが不正です。");
			return "administrator/login";
		} else {
			session.setAttribute("administratorName", ad2);
			return "forward:employee/showList";
		}
	}
}
