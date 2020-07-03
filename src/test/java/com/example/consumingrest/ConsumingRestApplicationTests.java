package com.example.consumingrest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.model.Transaction;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ConsumingRestApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testGetList() {
		webTestClient
		.get().uri("/transaction/list")
		.accept(MediaType.TEXT_PLAIN)
		.exchange()
		.expectStatus().isOk();
	}

	@Test
	void testGetSingle() {
		Transaction transaction = new Transaction(13, 55, 13, 22, false, true, 6);
		webTestClient
		.get().uri("/transaction/13")
		.accept(MediaType.TEXT_PLAIN)
		.exchange()
		.expectStatus().isOk()
		.expectBody(Transaction.class).isEqualTo(transaction);
	}

	@Test
	void testPostSingle() {
		Transaction transaction = new Transaction(6666, 55, 13, 22, false, true, 6);
		webTestClient
		.post().uri("/transaction/add")
		.accept(MediaType.TEXT_PLAIN)
		.exchange()
		.expectStatus().isOk()
		.expectBody(Transaction.class).isEqualTo(transaction);
	}

	@Test
	void testDeleteSingle() {
		webTestClient
		.delete().uri("/transaction/delete/13")
		.accept(MediaType.TEXT_PLAIN)
		.exchange()
		.expectStatus().isOk();
	}

	@Test
	void testDeleteAll() {
		webTestClient
		.delete().uri("/transaction/delete/all")
		.accept(MediaType.TEXT_PLAIN)
		.exchange()
		.expectStatus().isOk();
	}

}
