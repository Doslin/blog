package com.java.controller;


import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;



public class QinNiuUtil {

    /**

     @ClassName: QiniuUtils
     @Description: 七牛操作工具类
     @author Lanxiaowei(736031305@qq.com)
     @date 2017年6月6日 上午10:56:32
`       */




     private static final String ACCESS_KEY = "7Mh_BChcpiZ3UN_e3yEW73fCfOM34p5Vsu0cTrM-";
     private static final String SECRET_KEY = "-m55M9aOCnWxRC11cez8Umd90cqPg2CMgh3ZPDjw";
     //默认上传空间
     private static final String BUCKET_NAME = "doude_blog_file";// 默认到其他类中
     /* 空间默认域名 */
    private static  Configuration cfg = new Configuration(Zone.zone0());
    private static final String BUCKET_HOST_NAME = "doude_blog_file";
    private static final String HOST_URL = "http://img.takeing.cn/";

    private static UploadManager uploadManager = new UploadManager(cfg);

    private static int LIMIT_SIZE = 1000;



    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param @param inputStream 待上传文件输入流
     * @param @param bucketName 空间名称
     * @param @param key 空间内文件的key
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public static String uploadFile(InputStream inputStream,
                                    String key) throws IOException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(BUCKET_HOST_NAME);

        byte[] byteData = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(byteData, key, token, null, null,
                false);
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        String path = HOST_URL+ putRet.key;
        inputStream.close();
        return path;
    }



}



