package com.vonhutrong.collectingbeansbygroupdemo.beans;

import com.vonhutrong.collectingbeansbygroupdemo.annotations.ContextEnum;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class AnotherBeanTest {

    @Autowired
    private AnotherBean anotherBean;

    public static Stream<Arguments> provideContextAndExpectedBeanNames() {
        return Stream.of(
                Arguments.of(ContextEnum.CONTEXT_1, List.of("beanA", "beanC")),
                Arguments.of(ContextEnum.CONTEXT_2, List.of("beanB", "beanC")),
                Arguments.of(ContextEnum.CONTEXT_3, Collections.singletonList("beanC"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideContextAndExpectedBeanNames")
    void getBeanNamesForContext(ContextEnum context, List<String> expectedBeanNames) {
        List<String> beanNames = anotherBean.getBeanNamesForContext(context);
        assert beanNames.containsAll(expectedBeanNames);
    }
}