package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * @author liouwb
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @Override
    public BaseResp fileUpload(MultipartFile file, HttpServletRequest request) {

        if (file.isEmpty()) {
            new BaseResp(false, "fail", 500, "上传文件失败");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 获取文件类型
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        log.info("上传的文件类型为：{}", suffix);

        String filePath = "e:\\temp\\";
//        String filePath = request.getSession().getServletContext().getRealPath("/temp/imgs");

        // 判断文件夹是否存在，不存在就先创建一个
        if (!new File(filePath).isDirectory()) {
            new File(filePath).mkdir();
        }

        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return new BaseResp(true, "success", 200, "上传文件成功");
        } catch (IOException e) {
            log.error(e.toString(), e);
        }

        return new BaseResp(false, "fail", 500, "上传文件失败");
    }

    /**
     * 多个文件上传
     *
     * @param files
     * @return
     */
    @Override
    public BaseResp multiUpload(MultipartFile[] files) {
        String filePath = "e:\\temp\\";
        if (files.length == 0) {
            new BaseResp(false, "fail", 500, "请选择上传文件");
        }

        // 循环上传文件
        for (int i = 0; i < files.length; i++) {

            MultipartFile file = files[i];
            if (file.isEmpty()) {
                log.error("multiUpload 第{}个文件上传失败", i);

                new BaseResp(false, "fail", 500, "上传文件失败");
            }
            String fileName = file.getOriginalFilename();

            // 获取文件类型
            String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            log.info("上传的文件类型为：{}", suffix);

            // 判断文件夹是否存在，不存在就先创建一个
            if (!new File(filePath).isDirectory()) {
                new File(filePath).mkdir();
            }

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                log.error(e.toString(), e);
                log.error("multiUpload 第{}个文件上传失败", i);
                new BaseResp(false, "fail", 500, "上传文件失败");
            }
        }

        return new BaseResp(true, "success", 200, "上传文件成功");
    }

    /**
     * 文件下载
     */
    @Override
    public BaseResp downFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        // 1.获取文件下载的路径
        String path = "e:\\temp\\";
        // 2.获取下载文件的名称
        File file = new File(path, fileName);

        // 头信息设置
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 响应类型 与编码设置 下载文件的名字 URLEncoder编码来处理中文乱码
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        // 文件流
        FileInputStream fis = null;
        // 缓冲流
        BufferedInputStream bis = null;
        // 输出流
        OutputStream os;
        try {
            // 常见文件流
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            byte[] buffer = new byte[1024];

            // 获取输出流
            os = response.getOutputStream();

            int i;
            // 循环写入数据
            while ((i = bis.read(buffer)) != -1) {
                os.write(buffer, 0, i);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new BaseResp(false, "fail", 500, "下载文件失败");

        } catch (IOException e) {
            e.printStackTrace();
            new BaseResp(false, "fail", 500, "下载文件失败");
        } finally {
            // 关闭流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new BaseResp(true, "success", 200, "下载文件成功");
    }

}
