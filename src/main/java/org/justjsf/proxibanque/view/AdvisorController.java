package org.justjsf.proxibanque.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.justjsf.proxibanque.model.Advisor;
import org.justjsf.proxibanque.service.IAdvisorService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Cette classe sert de controlleur pour les vues permettant d'afficher et d'éditer un Conseiller
 * 
 * @author JustJSF
 *
 */
@Component(value = "advisorController")
@ViewScoped
public class AdvisorController implements Serializable {

	private static final long serialVersionUID = 6326248244940512537L;

	@Autowired
	private IAdvisorService advisorService;

	private Advisor bean;
	private Advisor beanSelected;
	private List<Advisor> list;
	private List<Advisor> listSelected;
	private String login;
	private String password;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.bean = new Advisor();
		this.beanSelected = new Advisor();
		this.list = new ArrayList<Advisor>();
		this.listSelected = new ArrayList<Advisor>();
		try {
			this.list.addAll(advisorService.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void save() {
		try {

			advisorService.persist(this.bean);
			refreshList();
			notificationSuccess("persist advisor");
		} catch (Exception e) {
			notificationError(e, "persist advisor");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			advisorService.merge(this.beanSelected);
			refreshList();
			notificationSuccess("update advisor");
		} catch (Exception e) {
			notificationError(e, "update advisor");
		}
	}

	public void delete() {
		try {
			advisorService.remove(this.beanSelected.getId());
			refreshList();
			notificationSuccess("delete advisor");
		} catch (Exception e) {
			notificationError(e, "delete advisor");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("form1:panel");
	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Opération effectuée");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public IAdvisorService getAdvisorService() {
		return advisorService;
	}

	public void setAdvisorService(IAdvisorService advisorService) {
		this.advisorService = advisorService;
	}

	public Advisor getBean() {
		return bean;
	}

	public void setBean(Advisor bean) {
		this.bean = bean;
	}

	public Advisor getBeanSelected() {
		return beanSelected;
	}

	public void setBeanSelected(Advisor beanSelected) {
		this.beanSelected = beanSelected;
	}

	public List<Advisor> getList() {
		if (list == null) {
			list = new ArrayList<Advisor>();
		}
		return list;
	}

	public void setList(List<Advisor> list) {
		this.list = list;
	}

	public List<Advisor> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Advisor> listSelected) {
		this.listSelected = listSelected;
	}

	public String login1() {
		boolean a = advisorService.isValid(login, password);
		if (a == true) {
			return "advisors/all";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("login", new FacesMessage("L'identifiant ou le mot de passe saisi est invalide"));
			return "login";
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

}
