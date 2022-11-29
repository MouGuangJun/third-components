package com.marshaller.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String dateStr) throws Exception {
        return formatter.parse(dateStr);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return formatter.format(date);
    }
}
