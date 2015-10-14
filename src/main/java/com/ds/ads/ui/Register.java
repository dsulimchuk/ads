package com.ds.ads.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class Register extends UI {
	TextField firstName   = new TextField("Имя");
	TextField secondName  = new TextField("Фамилия");
	TextField middleName  = new TextField("Отчество");
	TextField phoneNumber = new TextField("Телефон");	
	TextField city		  = new TextField("Город");
	TextField county      = new TextField("Старна");
	Button    saveButton  = new Button("Сохранить");
	Button 	  canselButton = new Button("Отменить");
	HorizontalLayout layoutButton = new HorizontalLayout (saveButton, canselButton);
	VerticalLayout	 verticalLayout = new VerticalLayout(); 
	FormLayout form 	  = new FormLayout(firstName, secondName, middleName, phoneNumber, city, county, layoutButton, verticalLayout);	

	@WebServlet(value = "/Register", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Register.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		verticalLayout.setMargin(true);
		setContent(form);
	}

}






	