package de.asw.training.js;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This only works with Java Version < 15
 *
 *
 * cd c:\asw\asw-web2\C10_Java_Grundlagen\example-200-java-refresher
 *
 * "C:\Program Files\OpenJDK\jdk-11"\bin\java -cp target\classes de.asw.training.js.NashornJavaScriptEngineDemo
 * Warning: Nashorn engine is planned to be removed from a future JDK release
 * Result: 33
 */
class NashornJavaScriptEngineDemo {

    public static void main(String[] args) throws ScriptException {

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByExtension("js");

        Bindings bindings = scriptEngine.createBindings();
        bindings.put("a", 11);
        bindings.put("b", 22);

        Object result = scriptEngine.eval(
                "var c= a+b; c", //c=a+b, return c;
                bindings);

        System.out.println("Result: " + result);
    }
}
