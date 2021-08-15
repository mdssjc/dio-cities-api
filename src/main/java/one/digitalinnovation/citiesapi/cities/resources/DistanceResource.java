package one.digitalinnovation.citiesapi.cities.resources;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.service.DistanceService;
import one.digitalinnovation.citiesapi.cities.service.EarthRadius;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints para o cálculo de distâncias da entidade {@link City}.
 *
 * @author Marcelo dos Santos
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/distances")
@RestController
public class DistanceResource {

  private static final Logger log = LoggerFactory.getLogger(DistanceResource.class);
  private final DistanceService service;

  @GetMapping("/by-points")
  public Double byPoints(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
    log.info("byPoints");
    return service.distanceByPointsInMiles(city1, city2);
  }

  @GetMapping("/by-cube")
  public Double byCube(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2) {
    log.info("byCube");
    return service.distanceByCubeInMeters(city1, city2);
  }

  @GetMapping("/by-math")
  public Double byMath(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2,
                       @RequestParam final EarthRadius unit) {
    log.info("byMath");
    return service.distanceUsingMath(city1, city2, unit);
  }
}
