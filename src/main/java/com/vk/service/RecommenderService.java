package com.vk.service;

import java.util.List;

public interface RecommenderService<K, T> {

    List<K> getTop(T user, int limit);

    void addDocument(K document);
}
