package com.ws.altanet.util;

import java.sql.Time;
import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.*;

public class SqlTimestampAdapter extends XmlAdapter<Timestamp, Timestamp> {

    @Override
    public Timestamp marshal(Timestamp sqlDate) throws Exception {
        if(null == sqlDate) {
            return null;
        }
        return new Timestamp(sqlDate.getTime());
    }

    @Override
    public Timestamp unmarshal(Timestamp utilDate) throws Exception {
        if(null == utilDate) {
            return null;
        }
        return new Timestamp(utilDate.getTime());
    }

}