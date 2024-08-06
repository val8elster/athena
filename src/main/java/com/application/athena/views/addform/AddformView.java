package com.application.athena.views.addform;

import com.application.athena.components.pricefield.PriceField;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Add/form")
@Menu(icon = "line-awesome/svg/book-solid.svg", order = 3)
@Route(value = "add/form")
public class AddformView extends Composite<VerticalLayout> {

    public AddformView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        ProgressBar progressBar = new ProgressBar();
        TextField textField = new TextField();
        Hr hr = new Hr();
        TextField textField2 = new TextField();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField3 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextArea textArea = new TextArea();
        Hr hr2 = new Hr();
        Checkbox checkbox = new Checkbox();
        FormLayout formLayout2Col2 = new FormLayout();
        Select select = new Select();
        NumberField numberField = new NumberField();
        Hr hr3 = new Hr();
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        Hr hr4 = new Hr();
        FormLayout formLayout2Col3 = new FormLayout();
        PriceField price = new PriceField();
        DatePicker datePicker2 = new DatePicker();
        Hr hr5 = new Hr();
        Hr hr6 = new Hr();
        Checkbox checkbox2 = new Checkbox();
        Select select2 = new Select();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h1.setText("Add Book");
        h1.setWidth("max-content");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        progressBar.setValue(0.5);
        textField.setLabel("ISBN");
        textField.setWidth("100%");
        textField2.setLabel("Title");
        textField2.setWidth("100%");
        formLayout2Col.setWidth("100%");
        textField3.setLabel("Author");
        textField3.setWidth("min-content");
        datePicker.setLabel("Published");
        datePicker.setWidth("min-content");
        textArea.setLabel("Description");
        textArea.setWidth("100%");
        checkbox.setLabel("Part of Series?");
        checkbox.setWidth("100%");
        formLayout2Col2.setWidth("100%");
        select.setLabel("Series");
        select.setWidth("min-content");
        setSelectSampleData(select);
        numberField.setLabel("Volume");
        numberField.setWidth("min-content");
        checkboxGroup.setLabel("Genre");
        checkboxGroup.setWidth("100%");
        checkboxGroup.setItems("Order ID", "Product Name", "Customer", "Status");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        formLayout2Col3.setWidth("100%");
        price.setLabel("Price");
        price.setWidth("min-content");
        datePicker2.setLabel("Date bought");
        datePicker2.setWidth("min-content");
        checkbox2.setLabel("Read?");
        checkbox2.setWidth("100%");
        select2.setLabel("Rating");
        select2.setWidth("100%");
        setSelectSampleData(select2);
        buttonPrimary.setText("Submit");
        buttonPrimary.setWidth("100%");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Discard");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, buttonSecondary);
        buttonSecondary.setWidth("100%");
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(layoutColumn2);
        layoutColumn2.add(progressBar);
        layoutColumn2.add(textField);
        layoutColumn2.add(hr);
        layoutColumn2.add(textField2);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField3);
        formLayout2Col.add(datePicker);
        layoutColumn2.add(textArea);
        layoutColumn2.add(hr2);
        layoutColumn2.add(checkbox);
        layoutColumn2.add(formLayout2Col2);
        formLayout2Col2.add(select);
        formLayout2Col2.add(numberField);
        layoutColumn2.add(hr3);
        layoutColumn2.add(checkboxGroup);
        layoutColumn2.add(hr4);
        layoutColumn2.add(formLayout2Col3);
        formLayout2Col3.add(price);
        formLayout2Col3.add(datePicker2);
        formLayout2Col3.add(hr5);
        formLayout2Col3.add(hr6);
        formLayout2Col3.add(checkbox2);
        layoutColumn2.add(select2);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(buttonSecondary);
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
}
