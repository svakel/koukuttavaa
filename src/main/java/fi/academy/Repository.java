package fi.academy;

import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Resepti, String> {
    //huomaa, että repositoryyn täytyy kertoa luokka, jota käsitellään ja id:n tyyppi. Repoon voi lisätä omia metodeja//

    Resepti findReseptiByNimiContains(String haku);

    Iterable<Resepti> findReseptiByReseptikategoriaContains(String kategoria);

}


