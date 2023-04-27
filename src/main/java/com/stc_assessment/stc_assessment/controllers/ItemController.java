package com.stc_assessment.stc_assessment.controllers;

import com.stc_assessment.stc_assessment.entites.Item;
import com.stc_assessment.stc_assessment.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/item", produces = "application/json")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/createSpace")
    public ResponseEntity<?> createNewSpace(@RequestBody Item spaceItem) {
        return itemService.createNewSpace(spaceItem);
    }

    @PostMapping(value = "/createFolder/{spaceId}")
    public ResponseEntity<?> createNewFolder(@RequestBody Item folderItem, @PathVariable(value = "spaceId") Long spaceId) {
        return itemService.createNewFolder(folderItem, spaceId);
    }

    @PostMapping(value = "/createFile/{spaceId}/{folderId}")
    public ResponseEntity<?> createNewFile(@RequestBody Item fileItem, @PathVariable(value = "spaceId") Long spaceId,
                                           @PathVariable(value = "folderId") Long folderId) {
        return itemService.createNewFile(fileItem, spaceId, folderId);
    }

    @PostMapping(value = "/createFile/{spaceId}")
    public ResponseEntity<?> createNewFile(@RequestBody Item fileItem, @PathVariable(value = "spaceId") Long spaceId) {
        return itemService.createNewFile(fileItem, spaceId, null);
    }

}
