package com.liouxb.web.demo.service;

import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author liouwb
 */
public interface FileService {

    BaseResp fileUpload(MultipartFile file, HttpServletRequest request);

    BaseResp multiUpload(MultipartFile[] files);

    void downFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
