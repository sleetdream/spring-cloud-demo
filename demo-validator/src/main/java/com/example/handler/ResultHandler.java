package com.example.handler;

import com.example.consts.ResultConsts;
import com.example.utils.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * 捕获所有Rest接口返回值
 * springboot-Rest接口返回统一格式数据
 * 参考 https://blog.csdn.net/alisonyu/article/details/82833413
 */
@ControllerAdvice(annotations = RestController.class)
public class ResultHandler implements ResponseBodyAdvice{

    private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private static final Class[] annos={
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };

    @Override
    public boolean supports(MethodParameter returnType, Class converterType){
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        if (body instanceof ResultConsts){
            return ResultUtils.getResult((ResultConsts) body);
        }
        else if(body == null){
            return ResultUtils.getResult(ResultConsts.OK);
        }
        else{
            return ResultUtils.getResult(ResultConsts.OK, body);
        }
    }

} 