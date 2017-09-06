package org.justjsf.proxibanque.view;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.justjsf.proxibanque.model.CheckingAccount;
import org.justjsf.proxibanque.model.Customer;
import org.justjsf.proxibanque.model.SavingAccount;
import org.justjsf.proxibanque.service.IService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "accountController")
@ViewScoped
public class AccountController implements Serializable{
	
	private static final long serialVersionUID = -5592412249785230184L;

	@Autowired
	private IService service;

	private Customer bean;
	private Customer beanSelected;
	private CheckingAccount checkingAccount;
	private SavingAccount savingAccount;
	private Double balance = 0.0D;
	private LocalDateTime date;
	private Double overdraft = -1000D;
	private Double wageRate = 3.0D;

	@PostConstruct
	public void init() {
	}


	public void save() {
		try {

			service.persist(this.bean);
			notificationSuccess("persist customer");
		} catch (Exception e) {
			notificationError(e, "persist customer");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			service.merge(this.beanSelected);
			notificationSuccess("update customer");
		} catch (Exception e) {
			notificationError(e, "update customer");
		}
	}

	public void delete() {
		try {
			service.remove(this.beanSelected.getId());
			notificationSuccess("delete customer");
		} catch (Exception e) {
			notificationError(e, "delete customer");
		}
	}

	public void onCancel(RowEditEvent event) {
	}

	public void reset() {
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

	public IService getCustomerService() {
		return service;
	}

	public void setCustomerService(IService service) {
		this.service = service;
	}

	public Customer getBean() {
		return bean;
	}

	public void setBean(Customer bean) {
		this.bean = bean;
	}

	public Customer getBeanSelected() {
		return beanSelected;
	}

	public void setBeanSelected(Customer beanSelected) {
		this.beanSelected = beanSelected;
	}


	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}


	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Double getOverdraft() {
		return overdraft;
	}


	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}
	
	public SavingAccount getSavingAccount() {
		return savingAccount;
	}


	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}


	public Double getWageRate() {
		return wageRate;
	}


	public void setWageRate(Double wageRate) {
		this.wageRate = wageRate;
	}


	public void setCheckingAccount() {
		if (this.beanSelected != null && this.beanSelected.getCheckingAccount() == null) {
			this.checkingAccount = new CheckingAccount();
			this.checkingAccount.setBalance(this.balance);
			this.checkingAccount.setOverdraft(this.overdraft);
			this.checkingAccount.setDate(LocalDateTime.now());
			this.beanSelected.setCheckingAccount(this.checkingAccount);
			try {
				service.merge(this.beanSelected);
			} catch (Exception e) {
				notificationError(e, "Add Checking Account error");
			}
		}
}
	public void setSavingAccount() {
		if (this.beanSelected != null && this.beanSelected.getSavingAccount() == null) {
			this.savingAccount = new SavingAccount();
			this.savingAccount.setBalance(this.balance);
			this.savingAccount.setWageRate(this.wageRate);
			this.savingAccount.setDate(LocalDateTime.now());
			this.beanSelected.setSavingAccount(this.savingAccount);
			try {
				service.merge(this.beanSelected);
			} catch (Exception e) {
				notificationError(e, "Add Saving Account error");
			}
		}
	}

}
