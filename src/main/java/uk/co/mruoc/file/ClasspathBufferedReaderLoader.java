package uk.co.mruoc.file;

public class ClasspathBufferedReaderLoader extends BufferedReaderLoader {

    public ClasspathBufferedReaderLoader() {
        super(new ClasspathInputStreamLoader());
    }
}
