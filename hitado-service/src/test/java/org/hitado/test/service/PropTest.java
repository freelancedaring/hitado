package org.hitado.test.service;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropTest {

    @Test
    public void loadPropTest() {
        String code = "S99040014";
        ResourceBundleMessageSource resourceBundle = new ResourceBundleMessageSource();
        resourceBundle.setBasename("/messages/MessageResourcesTest");
        resourceBundle.setUseCodeAsDefaultMessage(true);
        resourceBundle.setDefaultEncoding("UTF-8");
        String message = resourceBundle.getMessage(code,
                new Object[] { "testrole" }, Locale.getDefault());

        Assert.assertNotNull(message);
        Assert.assertFalse(message.equals(code));
        System.out.println("messsage:" + message);
    }

}
