package com.application.athena.ui.views;

import com.application.athena.valueobjects.Series;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("series/add")
@Menu(icon = "line-awesome/svg/book-solid.svg", order = 4)
@Route(value = "series/add")
public class AddSeries extends Composite<VerticalLayout> {
    public AddSeries() {
        HorizontalLayout layoutRow = new HorizontalLayout();

        H1 h1 = new H1();

        VerticalLayout pageLayout = new VerticalLayout();
        FormLayout contentLayout = new FormLayout();

        TextField nameField = new TextField();
        TextField authorField = new TextField();
        Button submitButton = new Button();
        Button discardButton = new Button();

        //

        h1.setText("Add Series");
        h1.setWidth("max-content");

        nameField.setLabel("Name");
        nameField.setWidth("min-content");

        authorField.setLabel("Author");
        authorField.setWidth("min-content");

        submitButton.setText("Submit");
        submitButton.setWidth("100%");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        discardButton.setText("Discard");
        discardButton.setWidth("100%");
        //TODO

        //

        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.add(h1);

        contentLayout.setWidth("100%");
        contentLayout.add(nameField);
        contentLayout.add(authorField);

        pageLayout.setWidth("100%");
        pageLayout.getStyle().set("flex-grow", "1");
        pageLayout.add(contentLayout);
        pageLayout.add(submitButton);
        pageLayout.add(discardButton);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        getContent().add(pageLayout);

        //

        submitButton.addClickListener(e -> {
            Notification notification = new Notification();

            Div text = new Div();

            Button closeButton = new Button(new Icon("lumo", "cross"));
            closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
            closeButton.setAriaLabel("Close");
            closeButton.addClickListener(event -> {
                notification.close();
            });

            if(nameField.getValue().isEmpty() || authorField.getValue().isEmpty()){
                text = new Div(new Text(
                        "Please enter both name and author."));
                notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
            }
            else {
                Series s = new Series(nameField.getValue(), authorField.getValue());
                text = new Div(new Text(
                        "Series created successfully."));
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }
            HorizontalLayout layout = new HorizontalLayout(text, closeButton);
            layout.setAlignItems(FlexComponent.Alignment.CENTER);

            notification.add(layout);
            notification.open();
        });
    }
}