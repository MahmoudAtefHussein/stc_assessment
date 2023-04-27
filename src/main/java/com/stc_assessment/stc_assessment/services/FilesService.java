package com.stc_assessment.stc_assessment.services;

import com.stc_assessment.stc_assessment.dao.FilesRepository;
import com.stc_assessment.stc_assessment.entites.Files;
import com.stc_assessment.stc_assessment.entites.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FilesService {

    @Autowired
    private FilesRepository filesRepository;

    public Files addNewFile(byte[] fileBytes, String path, Item item) {
        Files files = new Files();
        files.setItem(item);
        files.setFileName(item.getName());
        files.setFilePath(path);
        files.setFileBinary(fileBytes);
        return filesRepository.save(files);
    }

    public ResponseEntity<?> viewFileMetaData(Long fileId) {
        try {
            if (fileId != null && fileId > 0) {
                Files files = filesRepository.findByFileIdAndGavePermissions(fileId);
                if (files != null) {
                    return new ResponseEntity<>(files.getFileBinary(), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("you can not view this file or there is no file exists", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("there is no file exists", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> downloadFile(Long fileId) {
        if (fileId != null && fileId > 0) {
            Files files = filesRepository.findByFileIdAndGavePermissions(fileId);
            if (files != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-disposition", "attachment; filename=" + files.getFileName());
                return ResponseEntity.ok().headers(headers)
                        .contentType(MediaType
                                .parseMediaType("application/" + files.getFilePath().substring(files.getFilePath().lastIndexOf(".") + 1)))
                        .body(files.getFileBinary());
            } else {
                return new ResponseEntity<>("you can not view this file or there is no file exists", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("there is no file exists", HttpStatus.BAD_REQUEST);
        }
    }

}
