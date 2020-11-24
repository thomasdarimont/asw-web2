package de.asw.training.js;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
