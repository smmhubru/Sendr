package ru.smmhub.sendr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smmhub.sendr.model.HelloWorld;



@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorld, Long> {
}
