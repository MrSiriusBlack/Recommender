package com.vk;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Нам дана функция которая оценивает релевантность документа пользователю
 *
 * interface Scorer<Document, User> {
 *     double getScore(Document doc, User user);
 * }
 *
 * Необходимо реализовать сервис который может сохранять документ и получать  топ К (limit) документов для пользователя по скору этой функции
 *
 * interface RecommenderService<Document, User> {
 * List<Document> getTop(User user, int limit);
 *
 * void addDocument(Document document);
 * }
 */

@SpringBootApplication
@Tag(name = "Recommendation service", description = "Сервис получения рекомендаций")
public class RecommendationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }
}