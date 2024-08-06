package com.application.athena.views.viewbookoverlay;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("view book overlay")
@Menu(icon = "line-awesome/svg/book-open-solid.svg", order = 5)
@Route(value = "book")
public class ViewbookoverlayView extends Composite<VerticalLayout> {

    public ViewbookoverlayView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Paragraph textLarge = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h1.setText("---book name---");
        h1.setWidth("max-content");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        textLarge.setText("Copy content of add book from api here.");
        textLarge.setWidth("100%");
        textLarge.getStyle().set("font-size", "var(--lumo-font-size-xl)");
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(layoutColumn2);
        layoutColumn2.add(textLarge);
    }
}
