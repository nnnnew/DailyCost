package com.example.nnnnew.dailycost.Model;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class ExpenseModel extends AppCompatActivity {

    private String m_catalogue;
    private int m_on_add_id;
    private int m_ic_id;

    public ExpenseModel(String m_catalogue, int m_on_add_id) {
        this.m_catalogue = m_catalogue;
        this.m_on_add_id = m_on_add_id;
    }

    public int getM_ic_id() {
        return m_ic_id;
    }

    public void setM_ic_id(int m_ic_id) {
        this.m_ic_id = m_ic_id;
    }

    public int getM_on_add_id() {

        return m_on_add_id;
    }

    public void setM_on_add_id(int m_on_add_id) {
        this.m_on_add_id = m_on_add_id;
    }

    public String getM_catalogue() {

        return m_catalogue;
    }

    public void setM_catalogue(String m_catalogue) {
        this.m_catalogue = m_catalogue;
    }



}
