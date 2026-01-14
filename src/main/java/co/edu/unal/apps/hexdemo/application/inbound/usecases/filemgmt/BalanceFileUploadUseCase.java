package co.edu.unal.apps.hexdemo.application.inbound.usecases.filemgmt;

import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;
import co.edu.unal.apps.hexdemo.domain.services.files.BalanceFileValidator;
import co.edu.unal.apps.hexdemo.domain.services.files.FileUploaderService;
import co.edu.unal.apps.hexdemo.domain.services.files.FileValidator;

public class BalanceFileUploadUseCase extends FileUploadUseCase {

        public BalanceFileUploadUseCase() {
            this.fileUploaderService = new FileUploaderService();
        }

        public void uploadFile( CostosFile file ) {
            CostosFile costosFile = new CostosFile();
            costosFile.setName(file.getName());
            this.fileUploaderService.uploadFile(costosFile, new BalanceFileValidator());
        }

}
