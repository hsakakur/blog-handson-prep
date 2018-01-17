package com.example.blog.webhook;

import java.nio.file.Paths;

import am.ik.blog.entry.Entry;
import am.ik.blog.entry.EntryId;
import am.ik.github.GitHubClient;
import am.ik.github.repositories.commits.CommitsResponse.Commit;
import am.ik.github.repositories.contents.ContentsResponse.File;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EntryFetcher {
	private final GitHubClient gitHubClient;

	public EntryFetcher(GitHubClient gitHubClient) {
		this.gitHubClient = gitHubClient;
	}

	public Mono<Entry> fetch(String owner, String repo, String path) {
		EntryId entryId = EntryId.fromFilePath(Paths.get(path));
		Mono<File> file = this.gitHubClient.file(owner, repo, path).get();
		Flux<Commit> commits = this.gitHubClient.commits(owner, repo)
				.get(params -> params.path(path));

		// TODO: 実装してください
		return Mono.empty();
	}
}
