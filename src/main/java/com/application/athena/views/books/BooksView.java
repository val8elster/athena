package com.application.athena.views.books;

import com.application.athena.data.SamplePerson;
import com.application.athena.services.SamplePersonService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("books")
@Menu(icon = "line-awesome/svg/book-dead-solid.svg", order = 0)
@Route(value = "")
@RouteAlias(value = "")
@Uses(Icon.class)
public class BooksView extends Composite<VerticalLayout> {

    public BooksView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Select select = new Select();
        Button buttonPrimary = new Button();
        Hr hr = new Hr();
        Select select2 = new Select();
        TextField textField = new TextField();
        Button buttonPrimary2 = new Button();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Grid minimalistGrid = new Grid(SamplePerson.class);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h1.setText("Books Overview");
        h1.setWidth("max-content");
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("min-content");
        layoutColumn2.getStyle().set("flex-grow", "1");
        select.setLabel("Sort By...");
        select.setWidth("100%");
        setSelectSampleData(select);
        buttonPrimary.setText("Sort!");
        buttonPrimary.setWidth("100%");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        select2.setLabel("Search By...");
        select2.setWidth("min-content");
        setSelectSampleData(select2);
        textField.setLabel("Keyword");
        textField.setWidth("min-content");
        buttonPrimary2.setText("Search!");
        buttonPrimary2.setWidth("100%");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        minimalistGrid.setWidth("100%");
        minimalistGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(minimalistGrid);
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(select);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(hr);
        layoutColumn2.add(select2);
        layoutColumn2.add(textField);
        layoutColumn2.add(buttonPrimary2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(minimalistGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
