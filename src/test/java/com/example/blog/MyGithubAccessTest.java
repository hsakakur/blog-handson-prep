package com.example.blog;

import am.ik.blog.entry.Entry;
import am.ik.blog.entry.EntryId;
import am.ik.github.AccessToken;
import am.ik.github.GitHubClient;
import com.example.blog.webhook.EntryFetcher;
import org.junit.Test;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

public class MyGithubAccessTest {
	@Test
	public void check() {
		String github = "hsakakur";
		String accessToken = "e7a97a3c854c842b65f20d447c6f853b1944c88a";

		EntryFetcher entryFetcher = new EntryFetcher(
				new GitHubClient(WebClient.builder(), new AccessToken(accessToken)));
		Mono<Entry> entry = entryFetcher
				.fetch(github, "demo-blog-posts", "content/00001.md")
				.doOnNext(e -> System.out.println("Entry = " + e));

        StepVerifier.create(entry)
                .expectNextMatches(e -> e != null && new EntryId(1L).equals(e.getEntryId()))
                .verifyComplete();
	}
}
