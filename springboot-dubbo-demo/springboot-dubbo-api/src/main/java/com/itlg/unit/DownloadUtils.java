package com.itlg.unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Desc: 文件下载工具类
 * @Author: huangxin
 * @Create: 2020/10/20
 **/
public class DownloadUtils {
    private static Logger logger = LoggerFactory.getLogger(DownloadUtils.class);

    /**
     * 单文件下载
     *
     * @param urlList
     * @param path
     */
    public static void downloadPicture(String urlList, String path, String name) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            //创建文件名
            String uuid = UUID.randomUUID().toString();
            String filePath;
            if (ObjectUtils.isEmpty(name)) {
                filePath = path + uuid + ".mp3";
            } else {
                filePath = path + name + ".mp3";
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void multiThreadDownload(String filePath, String url, int tnum) {
        //默认8线程下载
        if (tnum == 0) {
            tnum = 8;
        }
        try {
            // 要写入的文件
//            final File file = new File(filePath);
//            String newName = name.split("（")[0];
//            file = new File(filePath + newName + ".mp3");
            final File file = new File(filePath + getFileExtName(url));
            logger.info(file.getAbsolutePath());

            RandomAccessFile accessFile = new RandomAccessFile(file, "rwd");// 建立随机访问
            final URL ul = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
            conn.setConnectTimeout(2000);// 请求超时时间
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            int len = conn.getContentLength();// 文件长度
            accessFile.setLength(len);
            accessFile.close();
            final int block = (len + tnum - 1) / tnum;// 每个线程下载的块大小

            long startTime = System.currentTimeMillis(); //获取开始时间
            logger.info("开始下载--" + filePath);
            long endTime = 0;
            for (int i = 0; i < tnum; i++) {
                final int a = i;
                Thread thread = new Thread(new Runnable() {
                    int start = block * a;// 开始位置
                    int end = block * (a + 1) - 1;// 结束位置

                    @Override
                    public void run() {
                        HttpURLConnection conn2 = null;
                        RandomAccessFile accessFile2 = null;
                        InputStream in = null;
                        try {
                            conn2 = (HttpURLConnection) ul.openConnection();
                            conn2.setConnectTimeout(6000);// 请求超时时间
                            conn2.setRequestMethod("GET");
                            // TODO Auto-generated method stub
                            conn2.setRequestProperty("Range", "bytes=" + start
                                    + "-" + end + "");// 设置一般请求属性 范围
                            in = conn2.getInputStream();
                            byte[] data = new byte[1024 * 8];
                            int len = 0;
                            accessFile2 = new RandomAccessFile(file, "rwd");
                            accessFile2.seek(start);

                            while ((len = in.read(data)) != -1) {
                                accessFile2.write(data, 0, len);//并发写入
                            }

//                            long endTime = System.currentTimeMillis(); //获取结束时间
//                            logger.info("线程:" + a + "下载完成----耗时:" + (endTime - startTime) + "ms");
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } finally {
                            try {
                                accessFile2.close();
                                in.close();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }
                    }
                });

                thread.start();
                while (thread.isAlive() == true) {
                    endTime = System.currentTimeMillis(); //获取结束时间
                }
            }
            logger.info("下载完成--" + filePath + "--耗时:" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 文件后缀名
     *
     * @param url
     * @return
     */
    public static String getFileExtName(String url) {
        return url.substring(url.lastIndexOf("."));
    }

    /**
     * 文件后缀名 mp4
     *
     * @param url
     * @return
     */
    public static String getFileExtNameForMp4(String url) {
        if (url.contains("?")) {
            url = url.split("\\?")[0];
        }
        return url.substring(url.lastIndexOf("."));
    }
}