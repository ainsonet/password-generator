package com.example;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.List;
import java.util.Random;

@PageTitle("Person Form")
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        H1 h1 = new H1("Генератор Паролей");
        add(h1);
        setAlignItems(Alignment.CENTER);
        NumberField numberField = new NumberField("Длина Пароля");
        numberField.setValue(10.);
        numberField.setRequired(true);
        add(numberField);
        Checkbox checkboxLetters = new Checkbox("Буквы");
        Checkbox checkboxDigits = new Checkbox("Цифры");
        Checkbox checkboxSpecial = new Checkbox("Специальные Символы");
        add(checkboxLetters, checkboxDigits, checkboxSpecial);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button button = new Button("Сгенерировать");
        horizontalLayout.add(button);
        TextField passwordField = new TextField("Ваш Пароль");
        passwordField.setReadOnly(true);
        horizontalLayout.add(passwordField);
        horizontalLayout.setAlignItems(Alignment.BASELINE);
        add(horizontalLayout);
        button.addClickListener(e -> {
            String password = "";
            var passwordLength = numberField.getValue();
            var needLetters = checkboxLetters.getValue();
            var needDigits = checkboxDigits.getValue();
            var needSpecial = checkboxSpecial.getValue();
            var letters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
            Random randomizer = new Random();
            for (int i = 0; i < passwordLength; i++) {
                password += letters.get(randomizer.nextInt(letters.size()));;
            }
            passwordField.setValue(password);
        });
    }

}
