package com.xx.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {


    @GetMapping("/topicData")
    public JSONObject topicData(@RequestParam("topicName") String topicName) {
        String c = getStringByFilePath("C:\\Users\\小小\\Desktop\\topicCount.txt");
        return JSONObject.parseObject(c);
    }

    @GetMapping("/consumerGroupData")
    public JSONObject consumerGroupData() {
        String c = getStringByFilePath("C:\\Users\\小小\\Desktop\\consumerGroupInfo.txt");
        return JSONObject.parseObject(c);
    }

    private static String getStringByFilePath(String filePath) {
        try {
            // 使用java.nio.file.Files的readAllBytes方法读取文件的所有字节
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            // 将字节转换为字符串
            return new String(bytes);
        } catch (IOException e) {
            log.error("getStringByFilePath ERROR:", e);
        }
        return "";
    }
}
