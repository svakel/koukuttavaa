package fi.academy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KommenttiRepository extends MongoRepository  <Kommentti, String> {
    Iterable<Kommentti> findKommenttiByNimiCodeContains (String nimikode);

}
