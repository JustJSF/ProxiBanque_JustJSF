package org.justjsf.proxibanque.view;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.justjsf.proxibanque.model.Advisor;
import org.justjsf.proxibanque.model.Advisor.Role;



@ManagedBean
@SessionScoped
public class UserController {

	private String login, password;
	private Advisor advisor = new Advisor();
	private static Map<String, Advisor> users;
	private static Map<String, Advisor> usersD;

	static {
		users = new HashMap<String, Advisor>();
		usersD = new HashMap<String, Advisor>();
		usersD.put("director", new Advisor("director", "director", Role.DIRECTOR));
		users.put("advisor", new Advisor("advisor", "advisor", Role.ADVISOR));
	}

	public UserController() {	}

	public String checkPassword() {
		Advisor m = users.get(login); 
		if (m != null && m.getPassword().equals(password)) {
			return "/home.xhtml?faces-redirect=true";
		}
		else m = usersD.get(login);
		if (m != null && m.getPassword().equals(password)) {

			return "/homeD.xhtml?faces-redirect=true";
		}
		return "loginError.xhtml";
//	if("director".equalsIgnoreCase(login)&&"director".equalsIgnoreCase(password)) {
//		return "homeD.xhtml";
//		}
//	if("advisor".equalsIgnoreCase(login)&&"advisor".equalsIgnoreCase(password)) {
//		return "home.xhtml";
//		}
//	return "login.xhtml";
	}


	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

}
