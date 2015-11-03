package com.ds.ads.ui;

import com.ds.ads.model.Country;
import com.ds.ads.model.Region;
import com.ds.ads.ui.resources.GenericResource;
import com.vaadin.ui.*;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resources;
import org.springframework.web.client.RestTemplate;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.spring.annotation.SpringUI;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Title("Register Form")
@Theme("valo")
@SpringUI(path = "/register")
public class RegisterForm extends UI {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RegisterForm.class);

    private TextField login = new TextField("Login");
    private PasswordField pass = new PasswordField("Password");
    private TextField userName = new TextField("Имя");
    private TextField phoneNumber = new TextField("Телефон");
    private ComboBox countryCombo = new ComboBox("Страна");
    private ComboBox regionCombo = new ComboBox("Регион");
    private ComboBox cityCombo = new ComboBox("Город");
    private ComboBox locationCombo = new ComboBox("Район");
    private Button regButton = new Button("Зарегистрироваться", this::register);
    private FormLayout form =
            new FormLayout(login, pass, userName, phoneNumber, countryCombo, regionCombo, cityCombo, regButton);

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void init(VaadinRequest request) {
        userName.setRequired(true);
        phoneNumber.setRequired(true);
        login.setRequired(true);
        login.setRequiredError("Блеаять!");
        pass.setRequired(true);


        //fill country combo
        countryCombo.setFilteringMode(FilteringMode.CONTAINS);
        Resources<Country> countriesArray = GenericResource.getAllCountries();
        if (countriesArray != null) {
            countriesArray.
                    getContent().
                    stream().
                    forEachOrdered(c -> {
                        LOGGER.debug("fill country combobox" + c.getId() + "  " + c.getName());
                        countryCombo.addItem(c.getId());
                        countryCombo.setItemCaption(c.getId(), c.getName());
                    });
        }


        setContent(form);

        countryCombo.addValueChangeListener(event -> {
            regionCombo.clear();
            LOGGER.warn(String.valueOf(event.getProperty().getValue()));
            Long countryId = Long.valueOf(String.valueOf(event.getProperty().getValue()));
            Resources<Region> regionsArray = GenericResource.getAllRegionsByCountryId(countryId);
            LOGGER.warn("dfsd " + regionsArray);

            if (regionsArray != null) {
                regionsArray.
                        getContent().
                        stream().
                        forEachOrdered(c -> {
                            LOGGER.warn("dfsd1 " + c);
                            regionCombo.addItem(c.getId());
                            regionCombo.setItemCaption(c.getId(), c.getName());
                        });
            }
        });


    }

    public void register(Button.ClickEvent event) {
        if (!login.isValid()) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("login", userName.getValue());
        map.put("pass", pass.getValue());
        map.put("name", userName.getValue());
        map.put("location", locationCombo.getValue());

        List<Map<String, Object>> phones = new ArrayList<>();
        //TODO parse number
        Map<String, Object> phoneMap = new HashMap<>();
        phoneMap.put("phoneCode", "");
        phoneMap.put("phoneNumber", phoneNumber.getValue());
        phones.add(phoneMap);

        map.put("phones", phones);

        final String uri = "http://localhost:8080/api/login/register";
        URI result = restTemplate.postForLocation(uri, map);

    }
}

