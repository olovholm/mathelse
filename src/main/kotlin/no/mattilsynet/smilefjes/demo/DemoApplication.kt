package no.mattilsynet.smilefjes.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("no.mattilsynet.smilefjes.demo.repository")
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
