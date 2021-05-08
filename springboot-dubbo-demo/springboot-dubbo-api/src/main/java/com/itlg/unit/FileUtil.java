package com.itlg.unit;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 文件工具类
 */
@Slf4j
public class FileUtil {
    /**
     * 处理不同浏览器文件乱码问题
     * @param request
     * @param fileName
     * @return 返回处理后的文件名
     */
    public static final String processFileName(HttpServletRequest request, String fileName) {
        if (StrUtil.isEmpty(fileName)) {
            return null;
        }
        String newFileName = null;
        if (ServletUtil.isIE(request)) {
            newFileName = URLUtil.encode(fileName, "UTF-8");
        } else {
            try {
                newFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                log.error("文件名转换为中文时出现异常", e);
                newFileName += fileName;
            }
        }
        return newFileName;
    }
}
