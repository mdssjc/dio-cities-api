package one.digitalinnovation.citiesapi.cities.repositories;

import one.digitalinnovation.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repositório para a entidade {@link City}.
 *
 * @author Marcelo dos Santos
 */
public interface CityRepository extends JpaRepository<City, Long> {

  @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
  Double distanceByPoints(Long cityId1, Long cityId2);

  @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
  Double distanceByCube(Double lat1, Double lon1, Double lat2, Double lon2);
}
