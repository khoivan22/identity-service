package com.learn.Identity_service.util;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Objects;

public class Util {

    public static String mapParamMessage(String message, Map<String, Object> attributes, String [] paramNames){

        if(Objects.isNull(paramNames) || Objects.isNull(attributes)) return message;
        for (String param : paramNames) {
            String value = String.valueOf(attributes.get(param));
            message = message.replace(MessageFormat.format("'{'{0}'}'", param), value);
        }

        return message;
    }

    private Util(){}
}
