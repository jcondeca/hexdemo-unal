package co.edu.unal.apps.hexdemo.domain.services.files;

import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;

public interface FileValidator {
    boolean isValidFile(CostosFile file);
}
