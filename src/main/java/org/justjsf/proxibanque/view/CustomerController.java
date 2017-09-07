package org.justjsf.proxibanque.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.justjsf.proxibanque.model.Customer;
import org.justjsf.proxibanque.service.IService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

	private static final long serialVersionUID = 6326248244940512537L;

	@Autowired
	private IService service;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private Customer bean;
	private Customer beanSelected;
	private List<Customer> list;
	private List<Customer> listSelected;
	private List<Customer> listAudit;

	@PostConstruct
	public void init() {
		refreshList();
		refreshListAudit();
		createPieModels();
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

	public void refreshListAudit() {
		this.bean = new Customer();
		this.beanSelected = new Customer();
		this.list = new ArrayList<Customer>();
		this.listAudit = new ArrayList<Customer>();
		pieModel2 = new PieChartModel();
		pieModel1 = new PieChartModel();

		try {
			this.list.addAll(service.findAll());
			this.listAudit.addAll(service.getAudit());

		} catch (Exception e) {
			e.printStackTrace();
		}

		pieModel2.set("Clients ok", listSelected.size()-listAudit.size());
		pieModel2.set("Découvert important", listAudit.size());

	}

	public void save() {
		try {

			service.persist(this.bean);
			refreshList();
			notificationSuccess("persist customer");
		} catch (Exception e) {
			notificationError(e, "persist customer");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			service.merge(this.beanSelected);
			refreshList();
			notificationSuccess("update customer");
		} catch (Exception e) {
			notificationError(e, "update customer");
		}
	}

	public void delete() {
		try {
			service.remove(this.beanSelected.getId());
			refreshList();
			notificationSuccess("delete customer");
		} catch (Exception e) {
			notificationError(e, "delete customer");
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
		if (list == null) {
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

	public List<Customer> getListAudit() {
		return listAudit;
	}

	public void setListAudit(List<Customer> listAudit) {
		this.listAudit = listAudit;
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Comptes ok", listSelected.size());
		pieModel1.set("Comptes ko", listAudit.size());

		pieModel1.setTitle("Simple Pie");
		pieModel1.setLegendPosition("w");
	}

	private void createPieModel2() {

		pieModel2.setTitle("Répartition des comptes");
		pieModel2.setLegendPosition("e");
		pieModel2.setFill(false);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	private void createPieModels() {
		createPieModel1();
		createPieModel2();
	}

}
