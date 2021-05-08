package com.itlg.controller.updown;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.itlg.entity.vo.ExcelVO;
import com.itlg.excepion.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @PostMapping("/excelExport")
    @ApiOperation(value = "导出excel")
    public void excelExport(HttpServletResponse response) throws IllegalStateException, IOException {
        List<ExcelVO> excelVOList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ExcelVO excelVO = new ExcelVO();
            excelVO.setAge(i);
            excelVO.setNum(i);
            excelVO.setName("张三" + i);
            excelVOList.add(excelVO);
        }
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        //创建一个sheet
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "模板1").head(ExcelVO.class).build();
        excelWriter.write(excelVOList, writeSheet);
        //创建一个新的sheet
        writeSheet = EasyExcel.writerSheet(1, "模板2").head(ExcelVO.class).build();
        excelWriter.write(excelVOList, writeSheet);
        excelWriter.finish();
    }

    @PostMapping("/excelInput")
    @ApiOperation(value = "导入excel")
    public R<List<ExcelVO>> excelInput(MultipartFile file) {
        List<ExcelVO> excelVOList = new ArrayList<>();
        InputStream inputStream = null;
        if (null == file) {
            R.fail("上传附件不能为空！");
        }
        try {
            inputStream = file.getInputStream();
            excelVOList = EasyExcel.read(inputStream)
                    .head(ExcelVO.class)
                    .sheet(1)
                    .headRowNumber(1)
                    .doReadSync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.success(excelVOList);
    }


}
