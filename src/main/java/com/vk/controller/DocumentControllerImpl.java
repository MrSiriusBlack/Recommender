package com.vk.controller;

import com.vk.dto.Document;
import com.vk.dto.User;
import com.vk.service.RecommenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {

    private final RecommenderService recommenderService;

    @Override
    @GetMapping("/{size}")
    public List<Document> getTop(@PathVariable int size) {
        var response = recommenderService.getTop(new User(), size);
        return response;
    }

    @Override
    @PostMapping
    public void saveDocument(@RequestBody Document document) {
        recommenderService.addDocument(document);
    }
}