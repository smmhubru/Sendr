package ru.smmhub.sendr.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.smmhub.sendr.model.HelloWorld;
import ru.smmhub.sendr.repository.HelloWorldRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;



    public Mono<ResponseEntity<Void>> addNewHelloWorld(HelloWorld helloWorld) {
        return Mono.fromCallable(() -> {
            helloWorldRepository.save(helloWorld);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }).publishOn(Schedulers.boundedElastic());
    }

    public Mono<HelloWorld> getHelloWorld(Long id) {
        return Mono.fromCallable(() -> helloWorldRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Can't find hello world by Id %s", id.toString())
        ))).publishOn(Schedulers.boundedElastic());
    }

    public Flux<HelloWorld> getAll() {
        return Mono.fromCallable(helloWorldRepository::findAll).publishOn(Schedulers.boundedElastic()).flatMapIterable(x -> x);
    }

    public Mono<ResponseEntity<Void>> deleteHelloWorld(Long id) {
        return Mono.fromCallable(() -> {
            helloWorldRepository.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }).publishOn(Schedulers.boundedElastic());
    }

    public Mono<ResponseEntity<Void>> updateHelloWorldById(Long id, HelloWorld helloWorld) {
        return Mono.fromCallable(() -> {
            helloWorldRepository.findById(id).orElseThrow(() -> new RuntimeException(
                    String.format("Can't find hello world by Id %s", id.toString())));
            helloWorld.setId(id);
            helloWorldRepository.save(helloWorld);
            return ResponseEntity.<Void>ok(null);
        }).publishOn(Schedulers.boundedElastic());
    }
}
