package velorok.shop.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import velorok.shop.api.models.Bike;

@RepositoryRestResource(collectionResourceRel = "bikes", path = "bikes")
public interface BikeRepository extends MongoRepository<Bike, String> {

}
