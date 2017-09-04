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
import org.justjsf.proxibanque.model.Customer;
import org.justjsf.proxibanque.service.IService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component(value="customerController")
@ViewScoped
public class CustomerController implements Serializable {
	
	private static final long serialVersionUID = 6326248244940512537L;

	@Autowired
	private IService service;
	
	private Customer bean;
	private Customer beanSelected;
	private List<Customer> list;
	private List<Customer> listSelected;
	
	@PostConstruct
    public void init() {
		refreshList();
    }



	public void refreshList() {
		this.bean = new Customer();
		this.beanSelected = new Customer();
		this.list = new ArrayList<Customer>();
		this.listSelected = new ArrayList<Customer>();
		try {
			this.list.addAll(service.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void save() {
		try {
		    
			service.persist(this.bean);
			refreshList();
			notificationSuccess("persist customer");
		} catch (Exception e) {
			notificationError(e,"persist customer");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			service.merge(this.beanSelected);
			refreshList();
			notificationSuccess("update customer");
		} catch (Exception e) {
			notificationError(e,"update customer");
		}
	}

	public void delete() {
		try {
			service.remove(this.beanSelected.getId());
			refreshList();
			notificationSuccess("delete customer");
		} catch (Exception e) {
			notificationError(e,"delete customer");
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
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success"); 
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
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

	public List<Customer> getList() {
		if(list == null){
			list = new ArrayList<Customer>();
		}
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public List<Customer> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Customer> listSelected) {
		this.listSelected = listSelected;
	}

	
	
	
	
}
