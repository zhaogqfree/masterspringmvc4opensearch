package com.sample.masterspringmvc4opensearch.service;

import com.sample.masterspringmvc4opensearch.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * WeatherInfoService
 * TODO
 *
 * @author ZhaoGQ
 * 2019/1/20
 * 1.0
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class WeatherInfoService {

   /* public static void main(String[] args) throws UnsupportedEncodingException {
        WeatherInfoService.weatherInfo(new String("苏州".getBytes(),"UTF-8"));
    }*/

    public  String weatherInfo(String area) throws Exception {
        String host = "https://ali-weather.showapi.com";
        String path = "/area-to-id";
        String method = "GET";
        String appcode = "6bf099d28bdf44378ea10124d5778e00";
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("area", area);


        //try {
        /**
         * 重要提示如下:
         * HttpUtils请从
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
         * 下载
         *
         * 相应的依赖请参照
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
         */
        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        //System.out.println(response.toString());

        //获取response的body
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //} catch (Exception e) {
        //    e.printStackTrace();
        // }
        return result;
    }
}
