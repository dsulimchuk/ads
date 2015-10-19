package com.ds.ads.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("RegisterForm")
@Theme("valo")
@SpringUI(path = "/RegisterForm")
public class RegisterForm extends UI{

	private TextField firstName   = new TextField("Имя1");
	private TextField secondName  = new TextField("Фамилия");
	private TextField middleName  = new TextField("Отчество");
	private TextField phoneNumber = new TextField("Телефон");	
	private TextField city		  = new TextField("Город");
	private TextField county      = new TextField("Старна");
	private Button    saveButton  = new Button("Сохранить");
	private Button 	  canselButton = new Button("Отменить");
	private HorizontalLayout layoutButton = new HorizontalLayout (saveButton, canselButton);
	private VerticalLayout	 verticalLayout = new VerticalLayout(); 
	private FormLayout form 	  = new FormLayout(firstName, secondName, middleName, phoneNumber, city, county, layoutButton, verticalLayout);
	
	@Override
	protected void init(VaadinRequest request) {
		verticalLayout.setMargin(true);
		setContent(form);

		saveButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				verticalLayout.addComponent(new Label("Save"));
			}
		});		

		canselButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				verticalLayout.addComponent(new Label("Cansel"));
			}
		});			
	}
}

