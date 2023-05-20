package com.mar.telegram.db.mapper;

import com.mar.telegram.db.dto.ContentType;
import com.mar.telegram.db.dto.PostInfoDto;
import com.mar.telegram.db.entity.PostInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PostMapper {

    @Mapping(target = "typeDir", source = "postInfo.type.typeDir")
    PostInfoDto mapToDto(PostInfo postInfo);


    @Mapping(target = "type", source = "dto.typeDir")
    PostInfo mapToEntity(PostInfoDto dto);

    default ContentType getContentTypeByDir(String typeDir) {
        return ContentType.getTypeByDir(typeDir);
    }

}
