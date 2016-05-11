# Property Loader

This is a simple java library to enable loading of properties from files
either on the filesystem or from the classpath in fewer lines of code.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    classpath 'com.github.michaelruocco:property-loader:1.0.0'
}
```

Alternatively the jar is available for direct download from:
[Maven Central](http://search.maven.org/).

### Loading Properties

Once you have the jar on your classpath you can load your properties from
the file system by doing the following:

```
String path = "folder/file-system.properties";
PropertyLoader propertyLoader = new PropertyLoader();
Properties properties = propertyLoader.load(path);
```

Alternatively you can load a property file from the classpath by doing:

```
String path = "/package/classpath.properties";
PropertyLoader propertyLoader = new PropertyLoader();
Properties properties = propertyLoader.loadFromClasspath(path);
```

If the properties are not loaded the code will throw a PropertiesNotFoundException
but you are not forced to handle this if you do not want to, as I wouldn't
want my library to cause you to litter your code with try catch blocks unless
you actually want to write them.