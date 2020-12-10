package com.itlg.controller.updown;

import com.itlg.exception.R;
import io.swagger.annotations.Api;
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
@Api(tags = "文件上传")
public class UploadController {

    @PostMapping("/springUpload")
    public R springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        String str = System.getProperty("user.dir");
        str = str + "/file";
        File fileDir = new File(str);
        if (!fileDir.exists()) {//如果文件夹不存在
            fileDir.mkdir();//创建文件夹
        }
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
                if (file != null) {
                    String path = str + "/" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        return R.success("文件创建成功");
    }
}
