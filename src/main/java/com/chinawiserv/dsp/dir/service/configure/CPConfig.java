package com.chinawiserv.dsp.dir.service.configure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springside.modules.utils.text.JsonMapper;

import com.chinawiserv.dsp.base.common.util.FTPUtil;
import com.chinawiserv.dsp.dir.service.catalog.impl.DirDatasetServiceImpl;
import com.chinawiserv.dsp.dir.service.configure.impl.DirDevelopApisServiceImpl;
import com.chinawiserv.dsp.dir.service.configure.impl.DirHomeServiceImpl;
import com.chinawiserv.dsp.dir.service.configure.impl.DirNewsServiceImpl;
import com.chinawiserv.dsp.dir.service.configure.impl.DirSpecialAppsServiceImpl;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Configuration
public class CPConfig {

	@Value("${config.location:classpath:}conf/common.properties")
	String path;
	
	@PostConstruct
	private void initCPAdress() throws IOException {
		
		
		File file = ResourceUtils.getFile(path);
		DirNewsServiceImpl.fileCP = file;
		DirHomeServiceImpl.fileCP = file;
		DirSpecialAppsServiceImpl.fileCP = file;
		DirDevelopApisServiceImpl.fileCP = file;
		DirDatasetServiceImpl.fileCP = file;
		FTPUtil.fileCP = file;
		
	}
}
