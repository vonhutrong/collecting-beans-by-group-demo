package com.vonhutrong.collectingbeansbygroupdemo.beans;

import com.vonhutrong.collectingbeansbygroupdemo.annotations.ContextEnum;
import com.vonhutrong.collectingbeansbygroupdemo.annotations.CustomAnnotation;
import org.springframework.stereotype.Component;

@Component
@CustomAnnotation(context = {ContextEnum.CONTEXT_1})
public class BeanA {
}