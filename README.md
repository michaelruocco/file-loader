# File Loader

[![Build](https://github.com/michaelruocco/file-loader/workflows/pipeline/badge.svg)](https://github.com/michaelruocco/file-loader/actions)
[![codecov](https://codecov.io/gh/michaelruocco/file-loader/branch/master/graph/badge.svg?token=FWDNP534O7)](https://codecov.io/gh/michaelruocco/file-loader)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/272889cf707b4dcb90bf451392530794)](https://www.codacy.com/gh/michaelruocco/file-loader/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/file-loader&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/file-loader?branch=master)](https://bettercodehub.com/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_file-loader&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_file-loader)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_file-loader&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_file-loader)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_file-loader&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_file-loader)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_file-loader&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_file-loader)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.michaelruocco/file-loader.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.michaelruocco%22%20AND%20a:%22file-loader%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a simple java library to enable loading of properties from files
either on the filesystem or from the classpath in fewer lines of code.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```gradle
dependencies {
    compile "com.github.michaelruocco:file-loader:{latest-version}"
}
```

### Loading Properties

Once you have the jar on your classpath you can load your properties from
the file system by doing the following:

```java
String path = "folder/file-system.properties";
PropertyLoader propertyLoader = new FileSystemPropertyLoader();
Properties properties = propertyLoader.load(path);
```

Alternatively you can load a property file from the classpath by doing:

```java
String path = "package/classpath.properties";
PropertyLoader propertyLoader = new ClasspathPropertyLoader();
Properties properties = propertyLoader.load(path);
```

If the properties are not loaded the code will throw a PropertiesNotFoundException
but you are not forced to handle this if you do not want to.

### Loading File Content

You can also use the library to load file content as well as properties, again this
can be done either from the local file system or the classpath in the same way as
described for properties above

To load from the file system you would do:

```java
String path = "folder/file-system.txt";
FileContentLoader loader = new FileSystemFileContentLoader();
String content = loader.loadContent(path);
```

To load from the classpath you would do:

```java
String path = "package/classpath.txt";
FileContentLoader loader = new ClasspathFileContentLoader();
String content = loader.loadContent(path);
```

If the file content is not loaded the code will throw a FileContentLoadException
but you are not forced to handle this if you do not want to.

### Loading File Files

You can also use the library to load file lines as well as properties, again this
can be done either from the local file system or the classpath in the same way as
described for properties above

To load from the file system you would do:

```java
String path = "folder/file-system.txt";
FileLineLoader loader = new FileSystemFileLineLoader();
Collection<String> lines = loader.loadLines(path);
```

To load from the classpath you would do:

```java
String path = "package/classpath.txt";
FileLineLoader loader = new ClasspathFileLineLoader();
Collection<String> lines = loader.loadLines(path);
```

If the file content is not loaded the code will throw a FileContentLoadException
but you are not forced to handle this if you do not want to.

### Loading File Content in Unit Tests

A new static ContentLoader class has been added to allow easier loading
test data from files in unit tests if required. The class has static methods
which can be used to load data without creating an instance of a FileContentLoader
class, e.g:

```java
String myFileSystemContent = ContentLoader.loadContentFromFileSystem("folder/file.txt");
String myClasspathContent = ContentLoader.loadContentFromClasspath("package/file.txt");
```

### Loading File Content Base64 Encoded

It is also possible to load file content and have it automatically
encoded into Base64 format, there are alternative implementations of 
FileContentLoader that you can use to do this, again it can be done
from either the classpath or the file system.

To load from the file system you would do:

```java
String path = "folder/file-system.txt";
FileContentLoader loader = new FileSystemBase64FileContentLoader();
Properties properties = loader.loadContent(path);
```

To load from the classpath you would do:

```java
String path = "package/classpath.txt";
FileContentLoader loader = new ClasspathBase64FileContentLoader();
Properties properties = loader.loadContent(path);
```

If the file content is not loaded the code will throw a FileContentLoadException
but you are not forced to handle this if you do not want to.

### Loading Input Streams

It is also possible to load and input stream as well as file content
as a string. Again this can be done from either the classpath or
the file system.

To load an input stream from the file system you would do:

```java
String path = "folder/file-system.txt";
InputStreamLoader loader = new FileSystemInputStreamLoader();
InputStream inputStream = loader.load(path);
// don't forget to close the stream when you're done with it!
```

To load an input stream from the classpath you would do:

```java
String path = "package/file-system.txt";
InputStreamLoader loader = new ClasspathInputStreamLoader();
InputStream inputStream = loader.load(path);
// don't forget to close the stream when you're done with it!
```

If the file content is not loaded the code will throw a UncheckedIOException
but you are not forced to handle this if you do not want to.

### Fakes

There are also fake implementations of both FileContentLoader
and InputStreamLoader which you can use when unit testing classes
that use this library. They easily allow you to control the content
or stream that is returned, as well as allowing you to verify that
the correct path has been used when loading.

File Content Example:

```java
FakeFileContentLoader loader = new FakeFileContentLoader();
loader.setContent("my fake content"); // set the fake loader to return specified file content when load method is called

ClassUnderTest classUnderTest = new ClassUnderTest(loader); // pass your fake loader to your class under test
classUnderTest.doAction();

String pathPassedToLoadMethod = loader.getLastLoadedPath();
```

Input Stream Example:

```java
FakeInputStreamLoader loader = new FakeInputStreamLoader();
InputStream mockedStream = new ByteArrayInputStream("mockedStream".getBytes());
loader.setInputStream(mockedStream); // set the fake loader to return mocked input stream when load method is called

ClassUnderTest classUnderTest = new ClassUnderTest(loader); // pass your fake loader to your class under test
classUnderTest.doAction();

String pathPassedToLoadMethod = loader.getLastLoadedPath();
```

## Useful Commands

```gradle
// cleans build directories
// prints currentVersion
// formats code
// builds code
// runs tests
// checks for gradle issues
// checks dependency versions
./gradlew clean currentVersion dependencyUpdates criticalLintGradle spotlessApply build
```