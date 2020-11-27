package de.asw.training.annotations;

import java.lang.reflect.Method;

@Example(value="Beispiel-08-15", level = "medium")
public class AnnotationsExample {
	// ...

	@Example("Beispiel-08-15-01")
	public void beispielMethod1() {
		// ...
	}
	
	@Example(value = "Beispiel-08-15-02")
	public void beispielMethod2() {
		// ...
	}
	
	public static void main(String[] args) {
		
		AnnotationsExample anno = new AnnotationsExample();
		
		Class<? extends AnnotationsExample> clazz = anno.getClass();
		
		for(Method m : clazz.getMethods()) {
			Example example = m.getAnnotation(Example.class);
			if(example != null) {
				System.out.printf("Method m=%s is example=%s%n", m, example.value());
			}
		}
	}
}
