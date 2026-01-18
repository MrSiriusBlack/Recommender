package com.vk.service.impl;

import com.vk.client.Scorer;
import com.vk.dto.Document;
import com.vk.dto.DocumentScorer;
import com.vk.dto.User;
import lombok.RequiredArgsConstructor;
import com.vk.mapper.DocumentMapper;
import com.vk.repository.DocumentRepository;
import com.vk.service.RecommenderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommenderServiceImpl implements RecommenderService<Document, User> {

    private final DocumentMapper documentMapper;
    private final Scorer scorer;
    private final DocumentRepository documentRepository;

    @Override
    public List<Document> getTop(User user, int limit) {
        var documents = documentMapper.toDocumentList(documentRepository.findAll());
        List<DocumentScorer> documentScorers = new ArrayList<>();

        for (var d : documents) {
            documentScorers.add(new DocumentScorer(d, scorer.getScore(d, user)));
        }

        return documentScorers.stream()
                .sorted((d1, d2) -> d2.score().compareTo(d1.score()))
                .limit(limit)
                .map(DocumentScorer::document)
                .toList();
    }

    @Override
    public void addDocument(Document document) {
        documentRepository.saveAndFlush(documentMapper.toDocumentEntity(document));
    }
}
