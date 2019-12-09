package com.jjo.h2.mapper.security;

import com.jjo.h2.dto.security.PrivilegeDTO;
import com.jjo.h2.dto.security.RoleDTO;
import com.jjo.h2.model.security.AccessData;
import com.jjo.h2.model.security.Role;
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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role dtoToEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        role.setPrivileges( privilegeDTOSetToAccessDataSet( dto.getPrivileges() ) );

        return role;
    }

    @Override
    public RoleDTO entityToDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( entity.getId() );
        roleDTO.setName( entity.getName() );
        roleDTO.setPrivileges( accessDataSetToPrivilegeDTOSet( entity.getPrivileges() ) );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> entityToDto(List<Role> entity) {
        if ( entity == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( entity.size() );
        for ( Role role : entity ) {
            list.add( entityToDto( role ) );
        }

        return list;
    }

    protected AccessData privilegeDTOToAccessData(PrivilegeDTO privilegeDTO) {
        if ( privilegeDTO == null ) {
            return null;
        }

        AccessData accessData = new AccessData();

        accessData.setId( privilegeDTO.getId() );

        return accessData;
    }

    protected Set<AccessData> privilegeDTOSetToAccessDataSet(Set<PrivilegeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<AccessData> set1 = new HashSet<AccessData>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PrivilegeDTO privilegeDTO : set ) {
            set1.add( privilegeDTOToAccessData( privilegeDTO ) );
        }

        return set1;
    }

    protected PrivilegeDTO accessDataToPrivilegeDTO(AccessData accessData) {
        if ( accessData == null ) {
            return null;
        }

        PrivilegeDTO privilegeDTO = new PrivilegeDTO();

        privilegeDTO.setId( accessData.getId() );

        return privilegeDTO;
    }

    protected Set<PrivilegeDTO> accessDataSetToPrivilegeDTOSet(Set<AccessData> set) {
        if ( set == null ) {
            return null;
        }

        Set<PrivilegeDTO> set1 = new HashSet<PrivilegeDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AccessData accessData : set ) {
            set1.add( accessDataToPrivilegeDTO( accessData ) );
        }

        return set1;
    }
}
