package de.asw.training.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo2AnalyzeAndModify {

    public static void main(String[] args) throws Exception {

        Bar instance = new Bar();

        System.out.println("### Liefert Information über die “Struktur” eines Objektes:");
        ObjectInspector.inspect(instance);

        System.out.println("\n### Dynamische Methodenaufrufe durchführen:");
        System.out.println(instance.getClass().getMethod("someMethod", String.class).invoke(instance, "Welt"));

        System.out.println("\n### Manipulation von Objektzustand:");
        System.out.println(instance.someMethod("reflection"));

        Field value0Field = instance.getClass().getDeclaredField("stringField");
        value0Field.setAccessible(true);
        value0Field.set(instance, "huhu");

        System.out.println(instance.someMethod("Welt"));

        System.out.println("\n### Dynamisch neue Objektinstanz erzeugen");

        Bar newObj = (Bar)Class.forName("snippets.Obj").getDeclaredConstructor().newInstance();
        System.out.println(newObj);
    }


    static class ObjectInspector {

        public static void inspect(Object o) throws Exception {

            log("Inspecting object instance: %s%n", o);
            Class<?> clazz = o.getClass();

            log("%nInspecting class: %s%n", clazz);

            log("%nConstructor:%n");
            for (Constructor<?> ctor : clazz.getDeclaredConstructors()) {
                log("declared constructor: %s%n", ctor);
            }

            log("%nFields:%n");
            for (Field field : clazz.getDeclaredFields()) {

                field.setAccessible(true);
                log("declared field: %s with value: %s%n", field, field.get(o));
            }

            log("%nMethods%n");
            for (Method method : clazz.getDeclaredMethods()) {
                log("declared methods: %s%n", method);
            }

            if (clazz.getSuperclass() != Object.class) {
                inspect(clazz.getSuperclass());
            }
        }

        private static void log(String msg, Object... args) {
            System.out.printf(msg, args);
        }
    }
}