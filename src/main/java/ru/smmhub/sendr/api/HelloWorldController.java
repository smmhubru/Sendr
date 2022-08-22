package ru.smmhub.sendr.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.smmhub.sendr.model.HelloWorld;
import ru.smmhub.sendr.service.HelloWorldService;

@Slf4j
@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    @PostMapping("")
    public Mono<ResponseEntity<Void>> addNewHelloWorld(@RequestBody HelloWorld helloWorld) {
        return helloWorldService.addNewHelloWorld(helloWorld);
    }

    @GetMapping("/{id}")
    public Mono<HelloWorld> getHelloWorldById(@PathVariable Long id) {
        return helloWorldService.getHelloWorld(id);
    }

    @GetMapping("")
    public Flux<HelloWorld> getAllHelloWorlds() {
        return helloWorldService.getAll();
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteHelloWorldById(@PathVariable Long id) {
        return helloWorldService.deleteHelloWorld(id);
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Void>> updateHelloWorldById(@PathVariable Long id,
                                                           @RequestBody HelloWorld helloWorld) {
        return helloWorldService.updateHelloWorldById(id, helloWorld);
    }


}
