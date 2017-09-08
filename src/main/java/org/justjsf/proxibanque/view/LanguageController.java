package org.justjsf.proxibanque.view;


import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Cette classe sert de controlleur pour les vues permettant de changer la langue de l'utilisateur
 * 
 * @author JustJSF
 *
 */
@ManagedBean(name="languageController")
@SessionScoped
public class LanguageController {
private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public String changeLanguage(String language) {
	locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return "customers/all.xhtml";
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getLanguage() {
		return locale.getLanguage();
	}

}
