package com.github.andrelugomes.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utilitário para transformação de localização.
 *
 * @author Marcelo dos Santos
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringLocationUtils {

    public static Double[] transform(String geolocation) {
        String result = geolocation.replace("(", "").replace(")", "");
        String[] strings = result.trim().split(",");
        return new Double[]{Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }
}
