package com.jjo.h2.mapper;

import com.jjo.h2.dto.HTypeDTO;
import com.jjo.h2.model.HType;
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
public class HTypeMapperImpl implements HTypeMapper {

    @Override
    public HType dtoToEntity(HTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HType hType = new HType();

        hType.setId( dto.getId() );
        hType.setName( dto.getName() );

        return hType;
    }

    @Override
    public HTypeDTO entityToDto(HType entity) {
        if ( entity == null ) {
            return null;
        }

        HTypeDTO hTypeDTO = new HTypeDTO();

        hTypeDTO.setId( entity.getId() );
        hTypeDTO.setName( entity.getName() );

        return hTypeDTO;
    }

    @Override
    public List<HTypeDTO> entityToDto(List<HType> entity) {
        if ( entity == null ) {
            return null;
        }

        List<HTypeDTO> list = new ArrayList<HTypeDTO>( entity.size() );
        for ( HType hType : entity ) {
            list.add( entityToDto( hType ) );
        }

        return list;
    }
}
