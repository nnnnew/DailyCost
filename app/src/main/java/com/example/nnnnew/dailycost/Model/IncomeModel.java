package com.example.nnnnew.dailycost.Model;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class IncomeModel extends AppCompatActivity{

    private String m_catalogue;
    private int m_on_add_id;
    private int m_icon_id;

    public IncomeModel(String m_catalogue, int m_on_add_id) {
        this.m_catalogue = m_catalogue;
        this.m_on_add_id = m_on_add_id;
    }

    public int getM_icon_id() {
        return m_icon_id;
    }

    public void setM_icon_id(int m_icon_id) {
        this.m_icon_id = m_icon_id;
    }

    public int getM_on_add_id() {

        return m_on_add_id;
    }

    public void setM_icon_on_add_id(int m_icon_on_add_id) {
        this.m_on_add_id = m_icon_on_add_id;
    }

    public String getM_catalogue() {

        return m_catalogue;
    }

    public void setM_catalogue(String m_catalogue) {
        this.m_catalogue = m_catalogue;
    }

    /*
    String[] catalogue = {"Salary", "Bonus", "Investment", "Gift", "Other"};
    String[] idOnAdd = {"on_add_salary", "on_add_bonus", "on_add_investment", "on_add_gift", "on_add_other"};
    String[] idIcon = {"ic_salary", "ic_bonus", "ic_investment", "ic_gift", "ic_other"};*/
}
