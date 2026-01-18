package com.vk.client;

import com.vk.dto.Document;
import com.vk.dto.User;

public interface Scorer {

    double getScore(Document doc, User user);
}