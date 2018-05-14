package com.unreview.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.unreview.model.bo.DataResult;
import com.unreview.model.bo.enums.HttpMethod;
import com.unreview.model.bo.enums.TimeUnit;
import com.unreview.model.dto.response_controller.Test1Response;
import com.unreview.model.dto.response_controller.TestResponse;
import com.unreview.service.interfaces.ITestService;
import com.unreview.utils.http.HttpHelper;
import com.unreview.utils.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/test")
public class TestController {

    @Autowired
    private ITestService service;
    @Value("${redis.Host}")
    private String xxx;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public DataResult<TestResponse> getData(@PathVariable Integer id) throws Exception {

        return DataResult.ok(RedisHelper.builder(new TypeReference<TestResponse>() {})
                .key("key")
                .timeUnit(TimeUnit.Second)
                .timeValue(50L)
                .CallAsync(() ->
                        dd()));

    }
    public static TestResponse dd()
    {
        TestResponse response=new TestResponse();
        response.setName("lhj");
        return response;
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public DataResult<Test1Response>  TestHttpRequest() throws IOException, InstantiationException, IllegalAccessException {

    Test1Response data=  HttpHelper.builder(new TypeReference<Test1Response>(){}, new TypeReference<TestResponse>() {} )
                                    .url("https://class.hujiang.com/homeapi/v2/homepage/tagMixInfo/2")
                                    .header("token","***")
                                    .header("cookie","***")
                                    .method(HttpMethod.GET)
                                    .body(new TestResponse())
                                    .execute();
     return DataResult.ok(data);

    }
}
