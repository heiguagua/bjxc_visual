package com.chinawiserv.dsp.dir.controller.catalog;

import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by wiserv on 2017/11/8.
 */
@Controller
@RequestMapping("/welCommon")
public class WelCommonController extends BaseController {

    @Value("${config.location:classpath:}doc/dir.docx")
    private Resource filePath;

    @RequestMapping("/introduce")
    public  String introduce(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "/workflow";
    }


    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String filename = "目录管理系统用户手册.docx";
        if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
            filename = URLEncoder.encode(filename, "UTF-8");
        } else {
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition","attachment; filename=" + filename);
        return new ResponseEntity(FileUtils.readFileToByteArray(filePath.getFile()), headers, HttpStatus.OK);
    }
}
