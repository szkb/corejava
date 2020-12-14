package com.study.basicknowledge.http.httpstudy;

import java.util.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

/**
 * This example demonstrates how to use custom http headers.
 */
public class HttpClientCustomHeadersExample {

    public static void main(String... args) throws IOException {

        // create custom http headers for httpclient
        List<Header> defaultHeaders = Collections.singletonList(
            new BasicHeader("X-Default-Header", "default header httpclient"));

        // setting custom http headers on the httpclient
        CloseableHttpClient httpclient = HttpClients
                .custom()
                .setDefaultHeaders(defaultHeaders)
                .build();

        try {

            // setting custom http headers on the http request
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://httpbin.org/headers")
                    .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                    .setHeader(HttpHeaders.FROM, "https://memorynotfound.com")
                    .setHeader("X-Custom-Header", "custom header http request")
                    .build();

            System.out.println("Executing request " + request.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(request, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }
}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/httpclient/httpclient-custom-http-headers.html#article-start

