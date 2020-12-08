package com.itlg.controller.updown;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
@RestController
public class UploadController {

    @PostMapping("/springUpload")
    public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                System.out.println("================>"+file.getName());
                if (file != null) {
                    String path = "E:/" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }

        }
        return "/success";
    }
}
