# File Loader

[![Build Status](https://travis-ci.org/michaelruocco/file-loader.svg?branch=master)](https://travis-ci.org/michaelruocco/file-loader)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/file-loader/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/file-loader?branch=master)
[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/github/michaelruocco/file-loader/maven-metadata.xml.svg)](http://repo1.maven.org/maven2/com/github/michaelruocco/file-loader)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f2ee600bb48147589686ee5a78104275)](https://www.codacy.com/app/michael-ruocco/file-loader?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/file-loader&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/file-loader?branch=master)](https://bettercodehub.com/)

This is a simple java library to enable loading of properties from files
either on the filesystem or from the classpath in fewer lines of code.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:file-loader:4.0.0'
}
```

### Loading Properties

Once you have the jar on your classpath you can load your properties from
the file system by doing the following:

```
String path = "folder/file-system.properties";
PropertyLoader propertyLoader = new FileSystemPropertyLoader();
Properties properties = propertyLoader.load(path);
```

Alternatively you can load a property file from the classpath by doing:

```
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

```
String path = "folder/file-system.txt";
FileContentLoader loader = new FileSystemFileContentLoader();
String content = loader.loadContent(path);
```

To load from the classpath you would do:

```
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

```
String path = "folder/file-system.txt";
FileLineLoader loader = new FileSystemFileLineLoader();
Collection<String> lines = loader.loadLines(path);
```

To load from the classpath you would do:

```
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

```
String myFileSystemContent = ContentLoader.loadContentFromFileSystem("folder/file.txt");
String myClasspathContent = ContentLoader.loadContentFromClasspath("package/file.txt");
```

### Loading File Content Base64 Encoded

It is also possible to load file content and have it automatically
encoded into Base64 format, there are alternative implementations of 
FileContentLoader that you can use to do this, again it can be done
from either the classpath or the file system.

To load from the file system you would do:

```
String path = "folder/file-system.txt";
FileContentLoader loader = new FileSystemBase64FileContentLoader();
Properties properties = loader.loadContent(path);
```

To load from the classpath you would do:

```
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

```
String path = "folder/file-system.txt";
InputStreamLoader loader = new FileSystemInputStreamLoader();
InputStream inputStream = loader.load(path);
// don't forget to close the stream when you're done with it!
```

To load an input stream from the classpath you would do:

```
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

```
FakeFileContentLoader loader = new FakeFileContentLoader();
loader.setContent("my fake content"); // set the fake loader to return specified file content when load method is called

ClassUnderTest classUnderTest = new ClassUnderTest(loader); // pass your fake loader to your class under test
classUnderTest.doAction();

String pathPassedToLoadMethod = loader.getLastLoadedPath();
```

Input Stream Example:

```
FakeInputStreamLoader loader = new FakeInputStreamLoader();
InputStream mockedStream = new ByteArrayInputStream("mockedStream".getBytes());
loader.setInputStream(mockedStream); // set the fake loader to return mocked input stream when load method is called

ClassUnderTest classUnderTest = new ClassUnderTest(loader); // pass your fake loader to your class under test
classUnderTest.doAction();

String pathPassedToLoadMethod = loader.getLastLoadedPath();
```

## Running the Tests

You can run the unit tests for this project by running:

```
gradlew clean build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```