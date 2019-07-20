package uk.co.mruoc.file;

public class FileSystemBufferedReaderLoader extends BufferedReaderLoader {

    public FileSystemBufferedReaderLoader() {
        super(new FileSystemInputStreamLoader());
    }

}
