package one.digitalinnovation.citiesapi.cities.service;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.repositories.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.geo.Point;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;

/**
 * Testes das regras de negócio de {@link City}.
 *
 * @author Marcelo dos Santos
 */
@ExtendWith(MockitoExtension.class)
class DistanceServiceTest {

    @Mock
    CityRepository cityRepository;

    @InjectMocks
    DistanceService service;

    City ibate;
    City saoCarlos;

    @BeforeEach
    void setUp() {
        ibate = new City(4929L, "Ibaté", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
                         new Point(-21.95840072631836, -47.98820114135742));
        saoCarlos = new City(5254L, "São Carlos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
                             new Point(-22.01740074157715, -47.88600158691406));
    }

    @Test
    void shouldCalculateInMetersUsingPoints() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingPoints(4929L, 5254L, EarthRadius.METERS);

        assertThat(distance).isEqualTo(12426.810463475855);
    }

    @Test
    void shouldCalculateInMilesUsingPoints() {
        given(cityRepository.distanceByPoints(4929L, 5254L)).willReturn(7.57102293200459);

        Double distance = service.distanceByPointsInMiles(4929L, 5254L);

        assertThat(distance).isEqualTo(7.57102293200459);
    }

    @Test
    void shouldCalculateInMetersUsingCube() {
        Point ibateLocation = ibate.getLocation();
        Point saoCarlosLocation = saoCarlos.getLocation();
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
        given(cityRepository.distanceByCube(ibateLocation.getX(), ibateLocation.getY(), saoCarlosLocation.getX(), saoCarlosLocation.getY())).willReturn(12426.810463465172);

        Double distance = service.distanceByCubeInMeters(4929L, 5254L);

        assertThat(distance).isCloseTo(12426.810463475855, offset(0.01d));
    }

    @Test
    void shouldCalculateInMetersUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.METERS);

        assertThat(distance).isEqualTo(12426.810463475855);
    }

    @Test
    void shouldCalculateInKilometersUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.KILOMETERS);

        assertThat(distance).isCloseTo(12.426, offset(0.001d));
    }

    @Test
    void shouldCalculateInMilesUsingMath() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

        Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.MILES);

        assertThat(distance).isCloseTo(7.71, offset(0.01d));
    }
}
