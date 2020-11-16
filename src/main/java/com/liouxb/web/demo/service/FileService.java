package com.liouxb.web.demo.service;

import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liouwb
 */
public interface FileService {

    BaseResp fileUpload(MultipartFile file, HttpServletRequest request);

    BaseResp multiUpload(MultipartFile[] files);

    BaseResp downFile(HttpServletRequest request, HttpServletResponse response);
}
