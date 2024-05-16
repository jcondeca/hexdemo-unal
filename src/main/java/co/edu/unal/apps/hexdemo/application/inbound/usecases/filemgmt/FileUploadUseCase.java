package co.edu.unal.apps.hexdemo.application.inbound.usecases.filemgmt;

import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;
import co.edu.unal.apps.hexdemo.domain.services.files.FileUploaderService;

import java.io.File;

public abstract class FileUploadUseCase {

    protected FileUploaderService fileUploaderService;

    public abstract void uploadFile( CostosFile file );

    public static FileUploadUseCase getUseCaseAccordingToFileType(String fileType) {
        if (fileType.equals("balance")) {
            return new BalanceFileUploadUseCase();
        } else {
            throw new RuntimeException("Invalid file type");
        }
    }
}
