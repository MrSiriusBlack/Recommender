package com.vk.mapper;

import com.vk.dto.Document;
import com.vk.dto.DocumentRequest;
import com.vk.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DocumentMapper {

    Document toDocument(DocumentRequest documentRequest);

    List<Document> toDocumentList(List<DocumentEntity> documentEntityList);

    @Mapping(target = "id", ignore = true)
    DocumentEntity toDocumentEntity(Document document);
}