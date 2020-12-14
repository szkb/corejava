package com.study.basicknowledge.http.httpstudy;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * This example demonstrates the use of {@link HttpGet} request method.
 * and handling redirect strategy with {@link LaxRedirectStrategy}
 */
public class HttpClientRedirectHandlingExample {

    public static void main(String... args) throws IOException, URISyntaxException {

        CloseableHttpClient httpclient = HttpClients.custom()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();

        try {
            HttpClientContext context = HttpClientContext.create();
            HttpGet httpGet = new HttpGet("http://httpbin.org/redirect/3");
            System.out.println("Executing request " + httpGet.getRequestLine());
            System.out.println("----------------------------------------");

            httpclient.execute(httpGet, context);
            HttpHost target = context.getTargetHost();
            List<URI> redirectLocations = context.getRedirectLocations();
            URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);
            System.out.println("Final HTTP location: " + location.toASCIIString());

        } finally {
            httpclient.close();
        }
    }
}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/httpclient/httpclient-redirect-handling.html#article-start

