package in.inuron.traveller;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravellerRepository extends MongoRepository<Traveller, String> {
}
