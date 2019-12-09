package com.jjo.h2.mapper;

import com.jjo.h2.dto.HDTO;
import com.jjo.h2.dto.HTypeDTO;
import com.jjo.h2.dto.TagsDTO;
import com.jjo.h2.model.H;
import com.jjo.h2.model.HType;
import com.jjo.h2.model.Tags;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-25T20:36:19-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class HMapperImpl implements HMapper {

    @Override
    public H dtoToEntity(HDTO dto) {
        if ( dto == null ) {
            return null;
        }

        H h = new H();

        h.setId( dto.getId() );
        h.setName( dto.getName() );
        h.setUrl( dto.getUrl() );
        h.setCover( dto.getCover() );
        h.setScore( dto.getScore() );
        h.setType( hTypeDTOToHType( dto.getType() ) );
        h.setTags( tagsDTOListToTagsSet( dto.getTags() ) );

        return h;
    }

    @Override
    public HDTO entityToDTO(H entity) {
        if ( entity == null ) {
            return null;
        }

        HDTO hDTO = new HDTO();

        hDTO.setId( entity.getId() );
        hDTO.setName( entity.getName() );
        hDTO.setUrl( entity.getUrl() );
        hDTO.setCover( entity.getCover() );
        hDTO.setClicks( entity.getClicks() );
        hDTO.setScore( entity.getScore() );
        hDTO.setType( hTypeToHTypeDTO( entity.getType() ) );
        hDTO.setTags( tagsSetToTagsDTOList( entity.getTags() ) );
        hDTO.setModifiedDate( entity.getModifiedDate() );

        return hDTO;
    }

    protected HType hTypeDTOToHType(HTypeDTO hTypeDTO) {
        if ( hTypeDTO == null ) {
            return null;
        }

        HType hType = new HType();

        hType.setId( hTypeDTO.getId() );
        hType.setName( hTypeDTO.getName() );

        return hType;
    }

    protected Tags tagsDTOToTags(TagsDTO tagsDTO) {
        if ( tagsDTO == null ) {
            return null;
        }

        Tags tags = new Tags();

        tags.setId( tagsDTO.getId() );
        tags.setName( tagsDTO.getName() );

        return tags;
    }

    protected Set<Tags> tagsDTOListToTagsSet(List<TagsDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Tags> set = new HashSet<Tags>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TagsDTO tagsDTO : list ) {
            set.add( tagsDTOToTags( tagsDTO ) );
        }

        return set;
    }

    protected HTypeDTO hTypeToHTypeDTO(HType hType) {
        if ( hType == null ) {
            return null;
        }

        HTypeDTO hTypeDTO = new HTypeDTO();

        hTypeDTO.setId( hType.getId() );
        hTypeDTO.setName( hType.getName() );

        return hTypeDTO;
    }

    protected TagsDTO tagsToTagsDTO(Tags tags) {
        if ( tags == null ) {
            return null;
        }

        TagsDTO tagsDTO = new TagsDTO();

        tagsDTO.setId( tags.getId() );
        tagsDTO.setName( tags.getName() );

        return tagsDTO;
    }

    protected List<TagsDTO> tagsSetToTagsDTOList(Set<Tags> set) {
        if ( set == null ) {
            return null;
        }

        List<TagsDTO> list = new ArrayList<TagsDTO>( set.size() );
        for ( Tags tags : set ) {
            list.add( tagsToTagsDTO( tags ) );
        }

        return list;
    }
}
