package com.jaronnie.springboot.service;

import com.jaronnie.springboot.domain.vo.OssFileVo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

public interface IOssService {
    OssFileVo upload(MultipartFile file);

    ResponseEntity<Resource> download(String url) throws MalformedURLException;

    ResponseEntity<Resource> view(String url) throws MalformedURLException;
}
