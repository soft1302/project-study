package com.lgh.util;

import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoadUtil {
    private static String CONFIG_LOCATION = "codemao.config.location";
    private static String DATASOURCE_PASSWORD_KEY = "spring.datasource.password";
    private static String IS_DECRYPT = "decrypt";

    public static void loadSet() {
        InputStream inputStream = null;
        try {
            File file = ResourceUtils.getFile(System.getProperty(CONFIG_LOCATION));
            if (file.exists()) {
                inputStream = new BufferedInputStream(new FileInputStream(file));
                Properties props = new Properties();
                props.load(inputStream);
                props.setProperty(DATASOURCE_PASSWORD_KEY, props.getProperty(DATASOURCE_PASSWORD_KEY));
                props.forEach((key, value) -> {
                    if (value != null && String.valueOf(value).startsWith(IS_DECRYPT)) {
                        String strValue = String.valueOf(value);
                        String decrypt = strValue.substring(IS_DECRYPT.length() + 1, strValue.length() - 1);
                        System.setProperty((String) key, decrypt);
                    } else {
                        System.setProperty((String) key, (String) value);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
