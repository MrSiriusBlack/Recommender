package com.vk.client.impl;

import com.vk.client.Scorer;
import com.vk.dto.Document;
import com.vk.dto.User;

public class ScorerTestImpl implements Scorer {

    @Override
    public double getScore(Document doc, User user) {
        return 0.5d;
    }
}