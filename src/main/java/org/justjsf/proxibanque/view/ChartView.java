package org.justjsf.proxibanque.view;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import org.justjsf.proxibanque.service.IAdvisorService;
import org.justjsf.proxibanque.service.IService;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
 
@Component
public class ChartView implements Serializable {
 
	private static final long serialVersionUID = -7888132429875919878L;
    private BarChartModel animatedModel2;
    
    Locale locale = LocaleContextHolder.getLocale();
	ResourceBundle labels = ResourceBundle.getBundle("i18n/labels", locale);
    
    @Autowired
    IService service;
    @Autowired
    IAdvisorService advisorService;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 

    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
        
        animatedModel2 = initBarModel();
        animatedModel2.setTitle(labels.getString("header.transfer.history"));
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private BarChartModel initBarModel() {
    	BarChartModel model = new BarChartModel();
    	 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
    
}