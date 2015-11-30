package com.example.nnnnew.dailycost.Model;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class TransectionModel {

    String amount;
    String catalogue;
    int idIcon;

    public TransectionModel(String amount, String catalogue, int idIcon) {
        this.amount = amount;
        this.catalogue = catalogue;
        this.idIcon = idIcon;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
    }

    public String getCatalogue() {

        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public String getAmount() {

        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
