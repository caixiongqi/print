package com.sinosoft.print.core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
	
	private static Logger logger = LoggerFactory.getLogger(Client.class);
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\蔡雄奇\\Desktop\\print.doc");
		CloseableHttpResponse httpResponse = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost post = new HttpPost("http://localhost:8100/server/print");
            post.setEntity(MultipartEntityBuilder.create().addBinaryBody("file", file, ContentType.create("application/msword", Charset.forName("utf-8")), "print.doc")
                    .build());
            httpResponse = httpclient.execute(post);
            HttpEntity entity = httpResponse.getEntity();
            if(entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                logger.info("响应信息为: {}", result);
            }
        } catch (IOException e) {
            logger.error("打印失败", e);
            throw new RuntimeException("打印失败", e);
        } finally {
            IOUtils.closeQuietly(httpResponse);
        }
	}

}
