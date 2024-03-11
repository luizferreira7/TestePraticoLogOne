package com.teste.pratico.model.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomMapper {

    public static <O, Target> O map(Object instance, Class<Target> targetClass) {
        if (instance.getClass().isPrimitive() || targetClass.isPrimitive()) {
            throw new RuntimeException("Provide a non primitive class");
        }

        if (instance.getClass().isInterface() || targetClass.isInterface()) {
            throw new RuntimeException("Provide a non interface class");
        }

        if (instance.getClass().isEnum() || targetClass.isEnum()) {
            throw new RuntimeException("Provide a non enum class");
        }

        if (Modifier.isAbstract(instance.getClass().getModifiers()) || Modifier.isAbstract(targetClass.getModifiers())) {
            throw new RuntimeException("Provide a non abstract class");
        }

        try {
            return doMap(instance, instance.getClass(), targetClass);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static <O, Source, Target> O doMap(Object sourceInstance, Class<Source> sourceClass, Class<Target> targetClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Set<Field> declaredSourceFields = findAllFields(sourceClass);
        Set<Field> declaredTargetFields = findAllFields(targetClass);

        Object targetInstance = targetClass.getDeclaredConstructor().newInstance();

        for (Field field : declaredTargetFields) {
            Field sourceField = findSourceField(field, declaredSourceFields);
            if (sourceField != null) {
                field.setAccessible(true);
                field.set(targetInstance, sourceField.get(sourceInstance));
            }
        }
        return (O) targetInstance;
    }

    public static Set<Field> findAllFields(Class<?> inputClass) {
        Set<Field> allFields = new HashSet<>();

        if (inputClass == null) {
            return allFields;
        }

        Field[] fields = inputClass.getDeclaredFields();
        allFields.addAll(Arrays.asList(fields));
        allFields.addAll(findAllFields(inputClass.getSuperclass()));
        return allFields;
    }

    private static Field findSourceField(Field targetField, Set<Field> declaredSourceFields) {
        for (Field field : declaredSourceFields) {
            field.setAccessible(true);
            String sourceFieldName = field.getName();
            if (sourceFieldName.equals(targetField.getName()) &&
                    field.getType().equals(targetField.getType())) {
                return field;
            }
        }
        return null;
    }
}
