package com.application.athena.ui.views;

import com.application.athena.services.Logic;
import com.application.athena.valueobjects.Book;
import com.application.athena.valueobjects.enums.Colour;
import com.application.athena.valueobjects.enums.CoverType;
import com.application.athena.valueobjects.enums.Genre;
import com.application.athena.valueobjects.enums.Language;
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
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.Arrays;
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

        Hr hr1 = new Hr();

        FormLayout layout = new FormLayout();

        Select languageSelect = new Select();
        NumberField pagesField = new NumberField();

        Hr hr2 = new Hr();

        FormLayout seriesLayout = new FormLayout();

        Checkbox isSeries = new Checkbox();
        Select seriesSelect = new Select();
        NumberField seriesVolume = new NumberField();

        Hr hr3 = new Hr();

        CheckboxGroup genreCheckboxes = new CheckboxGroup();

        Hr hr4 = new Hr();

        FormLayout coverLayout = new FormLayout();

        RadioButtonGroup<String> coverType = new RadioButtonGroup<>();
        Select colourSelect = new Select();

        Hr hr7 = new Hr();

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

        publisherField.setLabel("Publisher");
        publisherField.setWidth("min-content");

        publishLayout.setWidth("100%");

        publishedDate.setLabel("Published");
        publishedDate.setWidth("min-content");

        descriptionArea.setLabel("Description");
        descriptionArea.setWidth("100%");

        languageSelect.setLabel("Language");
        languageSelect.setWidth("min-content");
        languageSelect.setItems(Language.values());

        pagesField.setLabel("Pages");
        pagesField.setWidth("min-content");
        pagesField.setValue(0d);

        seriesLayout.setWidth("100%");

        isSeries.setLabel("Part of Series?");
        isSeries.setWidth("100%");

        isSeries.addClickListener(e -> {
            if(isSeries.getValue()) {
                seriesSelect.setEnabled(true);
                seriesVolume.setEnabled(true);
            }
            else {
                seriesSelect.setEnabled(false);
                seriesSelect.clear();
                seriesVolume.setEnabled(false);
                seriesVolume.clear();
            }
        });

        seriesSelect.setLabel("Series");
        seriesSelect.setWidth("min-content");
        seriesSelect.setEnabled(false);

        seriesVolume.setLabel("Volume");
        seriesVolume.setWidth("min-content");
        seriesVolume.setEnabled(false);

        genreCheckboxes.setLabel("Genre");
        genreCheckboxes.setWidth("100%");
        genreCheckboxes.setItems(Genre.values());

        coverLayout.setWidth("100%");

        coverType.setLabel("Cover Type");
        coverType.setItems("SOFTCOVER", "HARDCOVER");
        coverType.setWidth("min-content");

        colourSelect.setLabel("Cover Colour");
        colourSelect.setItems(Colour.values());
        colourSelect.setWidth("min-content");

        buyLayout.setWidth("100%");

        price.setLabel("Price");
        price.setWidth("min-content");
        price.setValue(0.00);

        buyDate.setLabel("Date bought");
        buyDate.setWidth("min-content");

        isRead.setLabel("Read?");
        isRead.setWidth("100%");

        isRead.addClickListener(e -> {
            if(isRead.getValue()) {
                rating.setEnabled(true);
            }
            else {
                rating.setEnabled(false);
                rating.clear();
            }
        });

        rating.setLabel("Rating");
        rating.setWidth("100%");
        setRatingSelectData(rating);
        rating.setEnabled(false);

        submitButton.setText("Submit");
        submitButton.setWidth("100%");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        discardButton.setText("Discard");
        contentLayout.setAlignSelf(FlexComponent.Alignment.START, discardButton);
        discardButton.setWidth("100%");
        //TODO discard ?

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

        contentLayout.add(hr1);
        contentLayout.add(layout);

        layout.add(languageSelect);
        layout.add(pagesField);

        contentLayout.add(hr2);
        contentLayout.add(isSeries);
        contentLayout.add(seriesLayout);

        seriesLayout.add(seriesSelect);
        seriesLayout.add(seriesVolume);

        contentLayout.add(hr3);
        contentLayout.add(genreCheckboxes);

        contentLayout.add(hr7);
        contentLayout.add(coverLayout);

        coverLayout.add(coverType);
        coverLayout.add(colourSelect);

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

        //

        submitButton.addClickListener(e -> {
            Book b = logic.getTempLogic().currentBook;

            b.setTitle(titleField.getValue());
            b.setAuthor(authorField.getValue());
            b.setPublisher(publisherField.getValue());
            b.setPublishedYear(publishedDate.getValue().getYear());
            b.setDescription(descriptionArea.getValue());
            b.setLanguage((Language) languageSelect.getValue());
            List<Genre> genres = new ArrayList<>();
            for (Object g : genreCheckboxes.getSelectedItems()) {
                genres.add((Genre) g);
            }
            b.setGenres(genres);
            b.setCover(CoverType.valueOf(coverType.getValue()));
            b.setCoverColour((Colour) colourSelect.getValue());
            b.setPages(pagesField.getValue().intValue());
            b.setPrice(price.getValue().floatValue());
            b.setBuyDate(buyDate.getValue());
            b.setRead(isRead.getValue());
            if(isRead.getValue()){
                b.setRating(((SampleItem) rating.getValue()).value);
            }
            logic.getTempLogic().bookList.add(b);
        });
    }

    record SampleItem(int value, String label) {
    }

    private void setRatingSelectData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem(1, "✨"));
        sampleItems.add(new SampleItem(2, "✨✨"));
        sampleItems.add(new SampleItem(3, "✨✨✨"));
        sampleItems.add(new SampleItem(4, "✨✨✨✨"));
        sampleItems.add(new SampleItem(5, "✨✨✨✨✨"));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}