package com.application.athena.ui.views;

import com.application.athena.services.Logic;
import com.application.athena.valueobjects.Book;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Add")
@Menu(icon = "line-awesome/svg/book-solid.svg", order = 2)
@Route(value = "add")
public class AddBook extends Composite<VerticalLayout> {
    private Logic logic = Logic.getInstance();

    public AddBook() {
        HorizontalLayout titleLayout = new HorizontalLayout();
        VerticalLayout contentLayout = new VerticalLayout();

        ProgressBar progressBar = new ProgressBar();
        TextField isbnField = new TextField();
        FormLayout isbnTextLayout = new FormLayout();
        Paragraph isbnText = new Paragraph();
        Button submitButton = new Button();

        H1 title = new H1();
        title.setText("Add Book");
        title.setWidth("max-content");

        progressBar.setValue(0.5);

        isbnField.setLabel("isbn");
        isbnField.setWidth("100%");

        isbnTextLayout.add(isbnText);
        isbnTextLayout.setWidth("100%");

        isbnText.setText("Select text field and scan barcode or enter manually.");
        isbnText.setWidth("100%");
        isbnText.getStyle().set("font-size", "var(--lumo-font-size-xs)");

        submitButton.setText("Check!");
        submitButton.setWidth("100%");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        submitButton.addClickListener(e -> {
            Long isbn = Long.valueOf(isbnField.getValue());
            logic.getTempLogic().currentBook = new Book(isbn);
            UI.getCurrent().navigate("add/form");
        });

        //

        titleLayout.addClassName(Gap.MEDIUM);
        titleLayout.setWidth("100%");
        titleLayout.setHeight("min-content");

        titleLayout.add(title);

        contentLayout.setWidth("100%");
        contentLayout.getStyle().set("flex-grow", "1");

        contentLayout.add(progressBar);
        contentLayout.add(isbnField);
        contentLayout.add(isbnTextLayout);
        contentLayout.add(submitButton);

        getContent().add(titleLayout);
        getContent().add(contentLayout);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
