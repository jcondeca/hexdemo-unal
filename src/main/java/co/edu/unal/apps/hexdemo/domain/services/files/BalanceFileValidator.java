package co.edu.unal.apps.hexdemo.domain.services.files;

import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;

public class BalanceFileValidator implements FileValidator {
    @Override
    public boolean isValidFile(CostosFile file) {
        // validate file
        return true;
    }
}
