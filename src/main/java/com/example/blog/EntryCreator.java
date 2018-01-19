package com.example.blog;

import java.util.Optional;

import am.ik.blog.entry.*;
import am.ik.blog.entry.factory.EntryFactory;

import org.springframework.core.io.Resource;

public class EntryCreator {
	public static Entry createEntry(EntryId entryId, Content content, Title title,
			Categories categories, Tags tags, Author created, Author updated) {

		return Entry.builder()
				.entryId(entryId)
				.content(content)
				.frontMatter(
						new FrontMatter(title, categories, tags))
        .created(created)
				.updated(updated)
				.build();
	}

	public static Optional<Entry> createEntryFromMarkdown(Resource resource,
			Author created, Author updated) {
		EntryFactory factory = new EntryFactory();

		Optional<Entry.EntryBuilder> entryBuilder = factory.createFromYamlFile(resource);
		Optional<Entry> entry = entryBuilder.map(
				builder -> builder.entryId(EntryId.fromFileName(resource.getFilename()))
						.created(created)
						.updated(updated)
						.build());

		return entry;
	}
}
