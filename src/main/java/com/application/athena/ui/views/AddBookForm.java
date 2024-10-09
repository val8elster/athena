package com.application.athena.ui.views;

import com.application.athena.services.Logic;
import com.application.athena.valueobjects.enums.Genre;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
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
public class AddBookForm extends Composite<VerticalLayout> {
    private Logic logic = Logic.getInstance();

    public AddBookForm() {
        HorizontalLayout titleLayout = new HorizontalLayout();

        H1 title = new H1();

        VerticalLayout contentLayout = new VerticalLayout();

        ProgressBar progressBar = new ProgressBar();

        TextField isbnField = new TextField();

        TextField titleField = new TextField();

        Hr hr = new Hr();

        FormLayout publishLayout = new FormLayout();

        TextField authorField = new TextField();
        DatePicker publishedDate = new DatePicker();
        TextField publisherField = new TextField();

        TextArea descriptionArea = new TextArea();

        Hr hr2 = new Hr();

        FormLayout seriesLayout = new FormLayout();

        Checkbox isSeries = new Checkbox();
        Select seriesSelect = new Select();
        NumberField seriesVolume = new NumberField();

        Hr hr3 = new Hr();

        CheckboxGroup genreCheckboxes = new CheckboxGroup();

        Hr hr4 = new Hr();

        FormLayout buyLayout = new FormLayout();

        NumberField price = new NumberField();
        Div euroSuffix = new Div();
        euroSuffix.setText("€");
        price.setSuffixComponent(euroSuffix);        

        DatePicker buyDate = new DatePicker();

        Hr hr5 = new Hr();

        Hr hr6 = new Hr();

        Checkbox isRead = new Checkbox();
        Select rating = new Select();

        Button submitButton = new Button();
        Button discardButton = new Button();

        titleLayout.addClassName(Gap.MEDIUM);
        titleLayout.setWidth("100%");
        titleLayout.setHeight("min-content");
        title.setText("Add Book");
        title.setWidth("max-content");

        progressBar.setValue(0.5);

        isbnField.setLabel("isbn");
        isbnField.setWidth("100%");

        titleField.setLabel("Title");
        titleField.setWidth("100%");

        authorField.setLabel("Author");
        authorField.setWidth("100%");

        publisherField.setLabel("Publisher");//TODO
        authorField.setWidth("min-content");

        publishLayout.setWidth("100%");

        publishedDate.setLabel("Published");
        publishedDate.setWidth("min-content");

        descriptionArea.setLabel("Description");
        descriptionArea.setWidth("100%");

        seriesLayout.setWidth("100%");

        isSeries.setLabel("Part of Series?");
        isSeries.setWidth("100%");

        seriesSelect.setLabel("Series");
        seriesSelect.setWidth("min-content");

        seriesVolume.setLabel("Volume");
        seriesVolume.setWidth("min-content");

        genreCheckboxes.setLabel("Genre");
        genreCheckboxes.setWidth("100%");
        genreCheckboxes.setItems(Genre.values());
        genreCheckboxes.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        buyLayout.setWidth("100%");

        price.setLabel("Price");
        price.setWidth("min-content");

        buyDate.setLabel("Date bought");
        buyDate.setWidth("min-content");

        isRead.setLabel("Read?");
        isRead.setWidth("100%");

        rating.setLabel("Rating");
        rating.setWidth("100%");

        submitButton.setText("Submit");
        submitButton.setWidth("100%");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        discardButton.setText("Discard");
        contentLayout.setAlignSelf(FlexComponent.Alignment.START, discardButton);
        discardButton.setWidth("100%");

        //

        titleLayout.add(title);

        contentLayout.setWidth("100%");
        contentLayout.getStyle().set("flex-grow", "1");

        contentLayout.add(progressBar);
        contentLayout.add(isbnField);
        contentLayout.add(titleField);
        contentLayout.add(hr);
        contentLayout.add(authorField);
        contentLayout.add(publishLayout);

        publishLayout.add(publisherField);
        publishLayout.add(publishedDate);

        contentLayout.add(descriptionArea);
        contentLayout.add(hr2);
        contentLayout.add(isSeries);
        contentLayout.add(seriesLayout);

        seriesLayout.add(seriesSelect);
        seriesLayout.add(seriesVolume);

        contentLayout.add(hr3);
        contentLayout.add(genreCheckboxes);
        contentLayout.add(hr4);
        contentLayout.add(buyLayout);

        buyLayout.add(price);
        buyLayout.add(buyDate);
        buyLayout.add(hr5);
        buyLayout.add(hr6);
        buyLayout.add(isRead);

        contentLayout.add(rating);
        contentLayout.add(submitButton);
        contentLayout.add(discardButton);

        //

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(titleLayout);
        getContent().add(contentLayout);

        //

        isbnField.setValue(String.valueOf(logic.getTempLogic().currentBook.isbn));
        isbnField.setEnabled(false);
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