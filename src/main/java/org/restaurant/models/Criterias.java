package org.restaurant.models;

public class Criterias {
    private String column;
    private String value;
    private String order;

    public Criterias(String column, String value, String order) {
        this.column = column;
        this.value = value;
        this.order = order;
    }

    public Criterias(String column, String value) {
        this.column = column;
        this.value = value;
    }


    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
