package com.unblu.demo.sampleoidcapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleOidcApplication

fun main(args: Array<String>) {
	runApplication<SampleOidcApplication>(*args)
}
