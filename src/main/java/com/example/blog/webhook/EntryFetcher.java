package com.example.blog.webhook;

import am.ik.blog.entry.Entry;
import am.ik.github.GitHubClient;
import reactor.core.publisher.Mono;

public class EntryFetcher {
	private final GitHubClient gitHubClient;

	public EntryFetcher(GitHubClient gitHubClient) {
		this.gitHubClient = gitHubClient;
	}

	public Mono<Entry> fetch(String owner, String repo, String path) {
		// TODO: 実装してください
		return Mono.empty();
	}
}
