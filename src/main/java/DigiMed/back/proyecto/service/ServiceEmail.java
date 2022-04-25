package DigiMed.back.proyecto.service;

import reactor.core.publisher.Mono;

public interface ServiceEmail {
    Mono<String> sendEmailMessage(String to, String subject, String text);
}
