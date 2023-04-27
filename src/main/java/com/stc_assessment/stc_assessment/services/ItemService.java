package com.stc_assessment.stc_assessment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.stc_assessment.stc_assessment.dao.ItemRepository;
import com.stc_assessment.stc_assessment.entites.Item;
import com.stc_assessment.stc_assessment.entites.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FilesService filesService;

    @Autowired
    private PermissionsService permissionsService;

    public ResponseEntity<?> createNewSpace(Item spaceItem) {
        try {
            return new ResponseEntity<>(createNewItem(spaceItem, null, null, "Space"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> createNewFolder(Item folderItem, Long spaceId) {
        try {
            return new ResponseEntity<>(createNewItem(folderItem, spaceId, null, "Folder"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> createNewFile(Item fileItem, Long spaceId, Long folderId) {
        try {
            return new ResponseEntity<>(createNewItem(fileItem, spaceId, folderId, "File"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private String createNewItem(Item item, Long spaceId, Long folderId, String itemType) throws IOException {
        if (item != null && itemType != null) {
            String parentSpaceName = "";
            if (itemType.equals("File") || itemType.equals("Folder")) {
                if (spaceId != null && spaceId > 0) {
                    Optional<Item> parentSpace = itemRepository.findById(spaceId);
                    if (parentSpace.isPresent()) {
                        parentSpaceName += File.separator + parentSpace.get().getName();
                    }
                }
                if (folderId != null && folderId > 0) {
                    Optional<Item> parentFolder = itemRepository.findById(folderId);
                    if (parentFolder.isPresent()) {
                        parentSpaceName += File.separator + parentFolder.get().getName();
                    }
                }
            }
            String path = System.getProperty("user.home");
            if (parentSpaceName != null && parentSpaceName.length() > 0) {
                path += parentSpaceName;
            }
            path += File.separator + item.getName();
            List<Permissions> permissions = null;
            if (item.getPermissionGroup() != null && item.getPermissionGroup().getId() != null && item.getPermissionGroup().getId() > 0) {
                permissions = permissionsService.getGroupPermissions(item.getPermissionGroup().getId());
            }
            File file = new File(path);
            file.setExecutable(true);
            file.setWritable(false, false);
            file.setReadable(false, false);
            if (permissions != null && permissions.size() > 0) {
                for (Permissions permission : permissions) {
                    if (permission != null && permission.getPermissionLevel() != null) {
                        if (permission.getPermissionLevel().equals("EDIT")) {
                            file.setWritable(true, false);
                        }
                        if (permission.getPermissionLevel().equals("VIEW")) {
                            file.setReadable(true, false);
                        }
                    }
                }
            }
            if (!file.exists()) {
                if (!itemType.equals("File")) {
                    file.mkdirs();
                }
                if (itemType.equals("File")) {
                    file.createNewFile();
                }
            }
            item.setType(itemType);
            item = itemRepository.save(item);
            if (itemType.equals("File")) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                byte[] fileBytes = objectMapper.writeValueAsBytes("Welcome To STC");
                writeBytesInFile(path, fileBytes);
                byte[] bytes = Files.readAllBytes(file.toPath());
                filesService.addNewFile(bytes, path, item);
            }
        }
        return itemType + " created successfully with ID [" + item.getId() + "]";
    }


    private void writeBytesInFile(String filePath, byte[] bytes) throws IOException {
        FileOutputStream jsonStream = new FileOutputStream(filePath);
        jsonStream.write(bytes);
        jsonStream.close();
    }
}
