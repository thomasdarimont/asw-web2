Maven Github Actions Example
---

Simple example project to play with github actions.

This example demonstrates the [maven build-lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

# Run

## mvn compile

Compile the project

```
mvn compile
```

## mvn test

Compile and run unit-tests in the project

```
mvn test
```

## mvn package

Compile, test and package the project

```
mvn package
```

Note it is possible to skip running the tests with the Parameter -DskipTests, e.g.:

```
mvn package -DskipTests
```

Execute the application on Windows:   

```
java -cp target\java-maven-example-1.0-SNAPSHOT.jar com.github.thomasdarimont.training.GreeterMain World
```

Execute the application on on Linux/OSX:  

```
java -cp target/java-maven-example-*.jar com.github.thomasdarimont.training.GreeterMain World
```

## mvn verify
Compile, test, package, run integration tests and check quality criteria

```
mvn verify
```

## mvn install 
Compile, test, package, run integration tests, check quality criteria and install artifact into local maven repository.  
Note that this is rarely needed.

```
mvn install 
```