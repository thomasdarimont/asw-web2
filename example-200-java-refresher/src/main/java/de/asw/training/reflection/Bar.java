package de.asw.training.reflection;

class Bar {

	private String stringField = "hallo";
	protected int intField = 42;

	public String someMethod(String arg) {
		return stringField + " " + arg;
	}
}