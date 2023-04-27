package com.stc_assessment.stc_assessment.controllers;

import com.stc_assessment.stc_assessment.services.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/files", produces = "application/json")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @GetMapping(value = "/viewFile/{fileId}")
    public ResponseEntity<?> viewFileMetaData(@PathVariable(value = "fileId") Long fileId) {
        return filesService.viewFileMetaData(fileId);
    }

    @GetMapping(value = "/downloadFile/{fileId}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileId") Long fileId) {
        return filesService.downloadFile(fileId);
    }
}
