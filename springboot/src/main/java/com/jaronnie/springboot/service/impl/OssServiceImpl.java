package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.domain.vo.OssFileVo;
import com.jaronnie.springboot.service.IOssService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class OssServiceImpl implements IOssService {
    private static final String UPLOAD_DIR = "data/uploads/";

    @Override
    public OssFileVo upload(MultipartFile file) {
        OssFileVo ossFileVo = new OssFileVo();

        if (file.isEmpty()) {
            return null;
        }

        try {
            // Generate a unique file name
            String fileName = generateFileName(file.getOriginalFilename());

            // Create the upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                // TODO: throw error
                Boolean b = uploadDir.mkdirs();
            }

            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDir.getAbsolutePath(), fileName);
            file.transferTo(filePath);

            // Get the file URL
            String fileUrl = getFileUrl(fileName);

            // Get file information
            ossFileVo.setUrl(fileUrl);
            ossFileVo.setUploadTime(new Date());
            ossFileVo.setName(fileName);
            return ossFileVo;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public ResponseEntity<Resource> download(String url) throws MalformedURLException {
        Path filePath = Paths.get(UPLOAD_DIR).resolve(url);
        Resource resource = new UrlResource(filePath.toUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(resource);
    }

    @Override
    public ResponseEntity<Resource> view(String url) throws MalformedURLException {
        Path filePath = Paths.get(UPLOAD_DIR).resolve(url);
        Resource resource = new UrlResource(filePath.toUri());
        MediaType mediaType = MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM);
        if (resource.exists() && canPreviewMediaType(mediaType)) {
            // 获取图片的真实内容类型
            mediaType = MediaTypeFactory.getMediaType(resource).orElse(MediaType.IMAGE_JPEG);

            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(resource);
        } else if (resource.exists() && !canPreviewMediaType(mediaType)) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .contentType(MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String generateFileName(String originalFileName) {
        // Generate a unique file name using the current timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String extension = StringUtils.getFilenameExtension(originalFileName);
        return extension != null ? timestamp + "." + extension : timestamp;
    }

    private boolean canPreviewMediaType(MediaType mediaType) {
        // 定义支持预览的媒体类型，例如图片类型
        return mediaType.isCompatibleWith(MediaType.IMAGE_JPEG) ||
                mediaType.isCompatibleWith(MediaType.IMAGE_PNG) ||
                mediaType.isCompatibleWith(MediaType.IMAGE_GIF);
    }

    private String getFileUrl(String fileName) {
        // Return the file URL based on your storage configuration
        // This could be a local URL or a CDN URL
        return "/oss/view/" + fileName;
    }
}
