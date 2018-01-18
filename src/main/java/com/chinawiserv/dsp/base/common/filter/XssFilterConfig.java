package com.chinawiserv.dsp.base.common.filter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springside.modules.utils.text.JsonMapper;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Configuration
public class XssFilterConfig {

    @Value("${config.location:classpath:}conf/checklist.properties")
    String path;

    @PostConstruct
    private void initWhiteList() throws IOException {
        Whitelist whitelist = new Whitelist();
        String jsonString = null;
        try {
            jsonString = FileUtils.readFileToString(ResourceUtils.getFile(this.path), Charset.forName("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(true);// 这里不设置，会把class属性过滤掉
        JSONObject jsonObject = JSONObject.fromObject(jsonString, config);
        JSONObject whitelistjson = jsonObject.getJSONObject("whiteList");
        JSONObject protocolsjson = jsonObject.getJSONObject("protocols");

        JsonMapper newMapper = new JsonMapper();
        Map<String, Map<String, String>> whitelistmap = newMapper.fromJson(whitelistjson.toString(), HashMap.class);
        Map<String, List<String>> protocolsmap = newMapper.fromJson(protocolsjson.toString(), HashMap.class);
        for (Map.Entry<String, Map<String, String>> entiy : whitelistmap.entrySet()) {
            String tag = entiy.getKey();
            whitelist.addTags(tag);
            for (Map.Entry<String, String> entiy2 : entiy.getValue().entrySet()) {
                String attribute = entiy2.getKey();
                whitelist.addAttributes(tag, attribute);
            }
        }
        for (Map.Entry<String, List<String>> entiy : protocolsmap.entrySet()) {
            String tag = entiy.getKey().substring(0, entiy.getKey().indexOf("."));
            String key = entiy.getKey().substring(entiy.getKey().indexOf(".") + 1, entiy.getKey().length());
            for (String entiy2 : entiy.getValue()) {
                whitelist.addProtocols(tag, key, entiy2);
            }
        }
        XssHttpServletRequestWrapperForUeditor.whitelist = whitelist;
    }
}
