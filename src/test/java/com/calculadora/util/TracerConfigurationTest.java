package com.calculadora.util;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class TracerConfigurationTest {
    @Autowired
    private TracerImpl tracer;
    @Test
    void testTracerImplBeanCreation() {
        assertNotNull(tracer);
    }
}
