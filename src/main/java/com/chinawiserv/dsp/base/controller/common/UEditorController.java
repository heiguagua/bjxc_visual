package com.chinawiserv.dsp.base.controller.common;

import com.baidu.ueditor.ActionEnter;
import com.chinawiserv.dsp.base.common.MD5Util;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by lianrongfa on 2017/9/13.
 */
@Controller
@RequestMapping(value = "/plugins")
public class UEditorController {
    protected static  String UPLOAD_PATH;
    protected static  String UPLOAD_NATIVE_READ;
    protected static  String UPLOAD_NATIVE;
    @RequestMapping(value = "/ueditor/jsp/ued.naah")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/uploadImageToNative")
    public void uploadImageToNative(@RequestParam(value = "upfile", required = false) MultipartFile upfile, HttpServletRequest request, ModelMap model){

            String imageStr="{\"state\": \"SUCCESS\",\"title\": \"1440128286827049816.jpg\",\"original\": \"10210558.jpg\",\"type\": \".jpg\",\"url\": \"/ueditor/jsp/upload/image/20150821/1440128286827049816.jpg\",\"size\": \"34221\"}";
            Date date = new Date();
            String imageName= date.toString()+upfile.getSize();
            JSONObject imageJson= JSONObject.fromObject(imageStr);
            imageJson.put("original",upfile.getOriginalFilename());
            imageJson.put("type", upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(".")));
            imageJson.put("title",imageName+imageJson.getString("type"));
            imageJson.put("size",upfile.getSize());
            imageJson.put("url", UPLOAD_NATIVE_READ+"/"+ imageJson.getString("title"));
            File newFile=new File(UPLOAD_NATIVE + imageJson.getString("title"));
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
   
    
    
    
}
