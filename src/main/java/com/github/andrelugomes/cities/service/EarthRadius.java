package com.github.andrelugomes.cities.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Constantes de medidas da Terra.
 *
 * @author Marcelo dos Santos
 */
@Getter
@AllArgsConstructor
public enum EarthRadius {

    METERS("m", 6378168),
    KILOMETERS("km", 6378.168f),
    MILES("mi", 3958.747716f);

    private final String unit;
    private final float value;
}
