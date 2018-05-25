package com.sinosoft.print.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "server")
public class PrintController {
	
	@Autowired
	private CorePrint corePrint;
	
	@RequestMapping(value = "/print", method = RequestMethod.POST)
	@ResponseBody
	public String print(@RequestParam("file") MultipartFile file) throws IOException {
		//corePrint.print((File)file);
		File newFile = new File("C:\\Users\\蔡雄奇\\Desktop\\测试.doc");
		FileOutputStream output = new FileOutputStream(newFile);
		IOUtils.copy(file.getInputStream(), output);
		IOUtils.closeQuietly(output);
		return "打印成功";
	}
}
