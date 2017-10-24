package uk.co.mruoc.properties;

public class FileSystemBase64FileContentLoader extends Base64FileContentLoader {

    public FileSystemBase64FileContentLoader() {
        super(new FileSystemFileContentLoader());
    }

}
