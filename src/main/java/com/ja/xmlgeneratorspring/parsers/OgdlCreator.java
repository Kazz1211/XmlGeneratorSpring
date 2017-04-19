package com.ja.xmlgeneratorspring.parsers;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OgdlCreator {
    private OgdlCreator() {
        
    }

    public static String objectToOgdlString(Object o) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o.getClass().getSimpleName() + "\n");
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            PropertyDescriptor[] pds = Introspector.getBeanInfo(o.getClass()).getPropertyDescriptors();
            for (Field field : fields) {
                for (PropertyDescriptor pd : pds) {
                    if (pd.getReadMethod() != null && pd.getName().equals(field.getName())) {
                        stringBuilder.append("\t");
                        if(field.getType().getSimpleName().equals("String")){
                            stringBuilder.append(field.getName() + " \"" + pd.getReadMethod().invoke(o)+"\"");
                        }
                        else{
                            stringBuilder.append(field.getName() + " " + pd.getReadMethod().invoke(o));
                        }
                        stringBuilder.append("\n");
                    }
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException ex) {
                        Logger.getLogger(OgdlCreator.class.getName()).log(Level.SEVERE, null, ex);

        }
        return stringBuilder.toString();
    }

    public static String collectionToOgdlString(Collection collection) {
        StringBuilder builder = new StringBuilder();
        for (Object o : collection) {
            builder.append(objectToOgdlString(o));
            builder.append("\n");
        }
        return builder.toString();
    }

    public static String collectionToOgdlString(Object[] collection) {
        return collectionToOgdlString(Arrays.asList(collection));
    }
}
