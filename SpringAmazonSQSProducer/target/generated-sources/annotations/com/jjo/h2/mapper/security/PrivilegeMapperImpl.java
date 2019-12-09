package com.jjo.h2.mapper.security;

import com.jjo.h2.dto.security.PrivilegeDTO;
import com.jjo.h2.model.security.Privilege;
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
public class PrivilegeMapperImpl implements PrivilegeMapper {

    @Override
    public Privilege dtoToEntity(PrivilegeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Privilege privilege = new Privilege();

        privilege.setId( dto.getId() );
        privilege.setName( dto.getName() );
        privilege.setDescription( dto.getDescription() );

        return privilege;
    }

    @Override
    public PrivilegeDTO entityToDto(Privilege entity) {
        if ( entity == null ) {
            return null;
        }

        PrivilegeDTO privilegeDTO = new PrivilegeDTO();

        privilegeDTO.setId( entity.getId() );
        privilegeDTO.setName( entity.getName() );
        privilegeDTO.setDescription( entity.getDescription() );

        return privilegeDTO;
    }

    @Override
    public List<PrivilegeDTO> entityToDto(List<Privilege> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PrivilegeDTO> list = new ArrayList<PrivilegeDTO>( entity.size() );
        for ( Privilege privilege : entity ) {
            list.add( entityToDto( privilege ) );
        }

        return list;
    }
}
