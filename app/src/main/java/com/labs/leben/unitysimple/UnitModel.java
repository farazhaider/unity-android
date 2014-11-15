package com.labs.leben.unitysimple;

/**
 * Created by Haider on 11/7/2014.
 */
public class UnitModel {
    public UnitModel(String name,double factor,String textfield,boolean flag){
        this.name=name;
        this.textfield=textfield;
        this.factor=factor;
        this.flag=flag;
    }
    protected String name;
    protected String textfield;
    protected double factor;
    protected boolean flag;
    protected static final String NAME_PREFIX = "Name_";
    protected static final String TEXTFIELD_PREFIX = "Textfield_";
    protected static final String FACTOR_PREFIX = "Factor_";

}
