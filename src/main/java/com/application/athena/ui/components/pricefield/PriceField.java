package com.application.athena.ui.components.pricefield;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;

public class PriceField extends CustomField<PriceField.Price> implements HasSize {

    public record Price(Double amount, String currency) {
    };

    private String[] currencies = new String[]{"EUR", "USD", "PLN"};

    private Select<String> currency;

    private NumberField amount;

    public PriceField() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);

        amount = new NumberField();
        amount.setPlaceholder("Amount");

        currency = new Select<>();
        currency.setItems(currencies);
        currency.setWidth("100px");

        horizontalLayout.add(amount, currency);

        add(horizontalLayout);
    }

    @Override
    protected Price generateModelValue() {
        return new Price(amount.getValue(), currency.getValue());
    }

    @Override
    protected void setPresentationValue(Price value) {
        amount.setValue(value.amount);
        currency.setValue(value.currency);
    }

}