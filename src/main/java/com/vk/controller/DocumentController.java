package com.vk.controller;

import com.vk.dto.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Document controller", description = "REST API для работы с документами")
public interface DocumentController {

    @Operation(summary = "Получение списка рекомендованных документов", description =
            "Возвращает список рекомендованных документов, отсортированный по убыванию показателя рекомендованности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список успешно получен")
    })
    List<Document> getTop(int size);

    @Operation(summary = "Добавление документа", description = "Добавляет документ в базу")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Документ успешно добавлен")
    })
    void saveDocument(Document document);
}