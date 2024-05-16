package co.edu.unal.apps.hexdemo.domain.services.files;

import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;

public class FileUploaderService {

    public void uploadFile(CostosFile file, FileValidator validator ) {
        if (validator.isValidFile(file)) {
            this.persistFile(file);
        } else {
            throw new IllegalArgumentException("Invalid file");
        }
    }

    private void persistFile(CostosFile file) {
        // upload file
    }
}
