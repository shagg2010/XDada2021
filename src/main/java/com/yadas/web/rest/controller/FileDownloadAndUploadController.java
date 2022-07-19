package com.yadas.web.rest.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yadas.web.rest.service.helper.UploadFileResponse;
import com.yadas.web.rest.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/file")
public class    FileDownloadAndUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileDownloadAndUploadController.class);

    @Autowired
    private FileStorageService fileStorageService;
    /*
    * Please use Postman Chrome extension to upload file, from Postman windows App, it is not working
    * Or use CURL command from Ubuntu (WSL) to upload file
    *       curl --location --request POST 'http://localhost:8080/file/upload' \
                --header 'Accept: application/json' \
                --form 'file=@"/mnt/e/workspace/XDada2021/resources/uploadSampleFile.txt"'
    *
    * Or set Content-Type = multipart/form-data;boundary=12345 (12345 is random value) in Postman
    * https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
    *
    *  TO CHECK UPLOADED FILE
    *  docker exec -it <CONTAINER_ID OF springboot-postgres-yadas> /bin/bash
    *  cat ./resources/uploadSampleFile.txt
    * */
    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        LOGGER.info("[LOG] uploading file='"+ file.getName() +"' of size='" + file.getSize() +"'.");
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/downloadFile/")
                .path(fileName)
                .toUriString();
        LOGGER.info("[LOG] uploaded file ='"+ fileName+"' of successfully!");
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultiple")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOGGER.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
