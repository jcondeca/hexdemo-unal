package co.edu.unal.apps.hexdemo.infrastructure.inbound.web.controllers;

import co.edu.unal.apps.hexdemo.application.inbound.usecases.filemgmt.FileUploadUseCase;
import co.edu.unal.apps.hexdemo.domain.model.files.CostosFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private FileUploadUseCase fileUploadUseCase;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Hexagonal Architecture!";
    }

    @PostMapping("/upload/{type}")
    public String upload(@PathVariable("type") String type) {

        fileUploadUseCase = FileUploadUseCase.getUseCaseAccordingToFileType(type);
        CostosFile file = new CostosFile("file.txt");
        fileUploadUseCase.uploadFile(
                file
        );
        return "OK";
    }
}
