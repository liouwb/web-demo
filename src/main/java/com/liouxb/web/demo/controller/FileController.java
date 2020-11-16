package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "file")
@Api(tags = "文件管理")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传单个文件")
    public BaseResp upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        return fileService.fileUpload(file, request);
    }

    @PostMapping("/multiUpload")
    @ApiOperation(value = "上传多个文件")
    public BaseResp multiUpload(@RequestParam("files") MultipartFile[] files) {

        return fileService.multiUpload(files);
    }

    /**
     * 下载文件
     * @PathVariable 传入参数不能有. param:.+ 表示来处理有.的参数
     */
    @GetMapping(value = "/downFile/{fileName:.+}")
    @ApiOperation(value = "文件下载")
    public BaseResp downFile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        return fileService.downFile(fileName, request, response);
    }

}
