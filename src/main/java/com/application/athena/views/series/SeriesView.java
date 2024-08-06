package com.application.athena.views.series;

import com.application.athena.data.services.SeriesService;
import com.application.athena.data.valueobjects.Series;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("series")
@Menu(icon = "line-awesome/svg/book-medical-solid.svg", order = 1)
@Route(value = "series")
@Uses(Icon.class)
public class SeriesView extends Composite<VerticalLayout> {

    public SeriesView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        ComboBox comboBox = new ComboBox();
        Button buttonPrimary = new Button();
        Hr hr = new Hr();
        Select select = new Select();
        TextField textField = new TextField();
        Button buttonPrimary2 = new Button();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Grid minimalistGrid = new Grid(Series.class);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h1.setText("Series Overview");
        h1.setWidth("max-content");
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        comboBox.setLabel("Sort By...");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        buttonPrimary.setText("Sort!");
        buttonPrimary.setWidth("100%");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        select.setLabel("Search By...");
        select.setWidth("min-content");
        setSelectSampleData(select);
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
        layoutColumn2.add(comboBox);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(hr);
        layoutColumn2.add(select);
        layoutColumn2.add(textField);
        layoutColumn2.add(buttonPrimary2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(minimalistGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
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
        grid.setItems(service.getAll());
    }

    @Autowired()
    private SeriesService service;
}
