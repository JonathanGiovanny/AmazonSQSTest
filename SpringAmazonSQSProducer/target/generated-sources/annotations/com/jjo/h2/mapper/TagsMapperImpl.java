package com.jjo.h2.mapper;

import com.jjo.h2.dto.TagsDTO;
import com.jjo.h2.model.Tags;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-25T20:36:19-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class TagsMapperImpl implements TagsMapper {

    @Override
    public Tags dtoToEntity(TagsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tags tags = new Tags();

        tags.setId( dto.getId() );
        tags.setName( dto.getName() );

        return tags;
    }

    @Override
    public TagsDTO entityToDto(Tags entity) {
        if ( entity == null ) {
            return null;
        }

        TagsDTO tagsDTO = new TagsDTO();

        tagsDTO.setId( entity.getId() );
        tagsDTO.setName( entity.getName() );

        return tagsDTO;
    }

    @Override
    public List<TagsDTO> entityToDto(List<Tags> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TagsDTO> list = new ArrayList<TagsDTO>( entity.size() );
        for ( Tags tags : entity ) {
            list.add( entityToDto( tags ) );
        }

        return list;
    }
}
