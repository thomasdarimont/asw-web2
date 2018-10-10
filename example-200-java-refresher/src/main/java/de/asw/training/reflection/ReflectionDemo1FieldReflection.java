package de.asw.training.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class ReflectionDemo1FieldReflection {

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        Class<?> fooClass = foo.getClass();
        Field[] fields = fooClass.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);

        System.out.printf("Instance=%s of type=%s contains:%n", foo, fooClass);
        for (Field field : fields) {
            System.out.printf("Field name=%s type=%s value=%s deprecated=%s%n",
                    field.getName(),
                    field.getType(),
                    field.get(foo),
                    field.isAnnotationPresent(Deprecated.class));
        }
    }
}