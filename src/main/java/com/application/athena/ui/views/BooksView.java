package com.application.athena.ui.views;

import com.application.athena.services.Logic;
import com.application.athena.valueobjects.Book;
import com.application.athena.valueobjects.enums.Genre;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("books")
@Menu(icon = "line-awesome/svg/book-dead-solid.svg", order = 0)
@Route(value = "")
@RouteAlias(value = "")
@Uses(Icon.class)
public class BooksView extends Composite<VerticalLayout> {
    private Logic logic = Logic.getInstance();
    public BooksView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Hr hr = new Hr();

        Select searchSelect = new Select();
        TextField searchField = new TextField();

        VerticalLayout layoutColumn3 = new VerticalLayout();

        Grid<Book> minimalistGrid = new Grid<>(Book.class, false);
        GridListDataView<Book> dataView = minimalistGrid.setItems(logic.getTempLogic().bookList);

        h1.setText("Books Overview");
        h1.setWidth("max-content");

        searchSelect.setLabel("Search By...");
        searchSelect.setWidth("min-content");
        setSearchSelectData(searchSelect);

        searchField.setLabel("Keyword");
        searchField.setWidth("min-content");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> dataView.refreshAll());

        minimalistGrid.addColumn(Book::getIsbn).setHeader("ISBN");
        minimalistGrid.addColumn(Book::getTitle).setHeader("Title").setSortable(true);
        minimalistGrid.addColumn(Book::getAuthor).setHeader("Author").setSortable(true);
        minimalistGrid.addColumn(Book::getRating).setHeader("Rating").setSortable(true);

        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        minimalistGrid.setWidth("100%");
        minimalistGrid.getStyle().set("flex-grow", "0");

        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.add(h1);

        layoutColumn2.setWidth("min-content");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.add(hr);
        layoutColumn2.add(searchSelect);
        layoutColumn2.add(searchField);

        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.add(layoutColumn2);
        layoutRow2.add(layoutColumn3);

        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.add(minimalistGrid);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        getContent().add(layoutRow2);

        //

        dataView.addFilter(book -> {
            String searchTerm = searchField.getValue().trim();

            if (searchTerm.isEmpty())
                return true;

            String searchCrit = ((SampleItem) searchSelect.getValue()).value;

            boolean match = false;
            switch(searchCrit){
                case "author": {
                    match = matchesTerm(book.getAuthor(), searchTerm);
                    break;
                }
                case "title": {
                    match = matchesTerm(book.getTitle(), searchTerm);
                    break;
                }
                case "genre": {
                    match = genreMatches(book.getGenres(), searchTerm);
                    break;
                }
                case "language": {
                    match = matchesTerm(book.getLanguage().toString(), searchTerm);
                    break;
                }
                case "cover": {
                    match = matchesTerm(book.getCover().toString(), searchTerm);
                    break;
                }
                case "read": {
                    match = matchesBoolean(book.isRead(), searchTerm);
                    break;
                }
            }
            return match;
        });
    }

    private boolean matchesBoolean(boolean read, String searchTerm) {
        return read && (searchTerm.toLowerCase().contains("true") || searchTerm.toLowerCase().contains("yes"));
    }

    private boolean matchesTerm(String value, String searchTerm) {
        return value.toLowerCase().contains(searchTerm.toLowerCase());
    }

    private boolean genreMatches(List<Genre> values, String searchTerm) {
        for(Genre g : values){
            if(g.toString().toLowerCase().contains(searchTerm.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    record SampleItem(String value, String label) {
    }

    private void setSearchSelectData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("title", "Title"));
        sampleItems.add(new SampleItem("author", "Author"));
        sampleItems.add(new SampleItem("language", "Language"));
        sampleItems.add(new SampleItem("genre", "Genre"));
        sampleItems.add(new SampleItem("cover", "Cover Type"));
        sampleItems.add(new SampleItem("read", "Is Read?"));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}