package com.vonhutrong.collectingbeansbygroupdemo.beans;

import com.vonhutrong.collectingbeansbygroupdemo.annotations.ContextEnum;
import com.vonhutrong.collectingbeansbygroupdemo.annotations.CustomAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnotherBean {

    private final ApplicationContext applicationContext;

    public AnotherBean(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<String> getBeanNamesForContext(ContextEnum context) {
        return applicationContext.getBeansWithAnnotation(CustomAnnotation.class)
                .keySet()
                .stream()
                .filter(beanName -> {
                    ContextEnum[] supportedContexts = applicationContext.findAnnotationOnBean(beanName, CustomAnnotation.class).context();
                    return Arrays.asList(supportedContexts).contains(context);
                })
                .collect(Collectors.toList());
    }
}