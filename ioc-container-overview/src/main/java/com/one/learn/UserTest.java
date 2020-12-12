package com.one.learn;

import com.one.learn.domain.User;

import java.beans.*;
import java.util.stream.Stream;

/**
 * @author one
 * @date 2020/12/12
 */
public class UserTest {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        Stream<PropertyDescriptor> propertyDescriptors = Stream.of(beanInfo.getPropertyDescriptors());
        propertyDescriptors.forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor.toString());
            propertyDescriptor.setPropertyEditorClass(StringToIntegerProeprtyEditor.class);
            propertyDescriptor.createPropertyEditor(new StringToIntegerProeprtyEditor());
        });
    }

    public static class StringToIntegerProeprtyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }

}
