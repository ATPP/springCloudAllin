package com.hom.wzuul.filter;

public abstract class WzuulFilter {

    abstract public String filterType();

    abstract public int filterOrder();

    abstract public void run();
}
