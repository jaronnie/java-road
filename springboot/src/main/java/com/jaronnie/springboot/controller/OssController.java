package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.vo.OssFileVo;
import com.jaronnie.springboot.service.IOssService;
import com.jaronnie.springboot.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

/*
 * OssController 提供文件服务支持
 *  - upload
 *  - download
 *  - view
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/oss")
public class OssController {
    private final IOssService iOssService;

    @PostMapping("/upload")
    @ResponseBody
    public R<OssFileVo> upload(@RequestParam("file") MultipartFile file) {
        return R.ok(iOssService.upload(file));
    }

    @GetMapping("/view/{url:.+}")
    public ResponseEntity<Resource> view(@PathVariable String url) throws MalformedURLException {
        return iOssService.view(url);
    }

    @GetMapping("/download/{url:.+}")
    public ResponseEntity<Resource> download(@PathVariable String url) throws MalformedURLException {
        return iOssService.download(url);
    }
}
