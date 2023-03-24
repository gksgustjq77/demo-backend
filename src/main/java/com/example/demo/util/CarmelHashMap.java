package com.example.demo.util;

import java.util.LinkedHashMap;

import org.apache.ibatis.type.Alias;
import org.springframework.jdbc.support.JdbcUtils;

@Alias("carmelHashMap")
@SuppressWarnings("rawtypes")
public class CarmelHashMap extends LinkedHashMap {
    private static final long serialVersionUID = -7700790403928325865L;

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        if (((String) key).indexOf("_") < 0) {
            return super.put((String) key, value);
        }
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key), value);
    }
}