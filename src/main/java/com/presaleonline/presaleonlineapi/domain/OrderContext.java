package com.presaleonline.presaleonlineapi.domain;

import java.util.Date;

public class OrderContext {

    private Provider provider;
    private Date date;


    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
