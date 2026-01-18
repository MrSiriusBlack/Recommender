package com.vk.client.impl;

import com.vk.client.Scorer;
import com.vk.dto.Document;
import com.vk.dto.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Service;

/**
 * По условию это должен быть внешний сервис, которые по паре <Document, User> возвращает показатель
 * рекомендованности Document для данного User. В тестовом варианте используется случайное число
 */
@Service
@ConditionalOnMissingClass("com.vk.client.impl.ScorerImpl")
public class ScorerStub implements Scorer {

    @Override
    public double getScore(Document doc, User user) {
        return Math.random();
    }
}