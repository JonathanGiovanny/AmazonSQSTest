package com.jjo.h2.mapper.security;

import com.jjo.h2.dto.security.SingUpDTO;
import com.jjo.h2.dto.security.UserDTO;
import com.jjo.h2.model.security.Role;
import com.jjo.h2.model.security.User;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-25T20:36:19-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User singUpToUser(SingUpDTO singUp) {
        if ( singUp == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( singUp.getUsername() );
        user.setPassword( singUp.getPassword() );
        user.setEmail( singUp.getEmail() );
        byte[] profilePic = singUp.getProfilePic();
        if ( profilePic != null ) {
            user.setProfilePic( Arrays.copyOf( profilePic, profilePic.length ) );
        }

        return user;
    }

    @Override
    public User dtoToEntity(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setStatus( userDto.getStatus() );
        user.setCreatedDate( userDto.getCreatedDate() );
        user.setPasswordDate( userDto.getPasswordDate() );
        byte[] profilePic = userDto.getProfilePic();
        if ( profilePic != null ) {
            user.setProfilePic( Arrays.copyOf( profilePic, profilePic.length ) );
        }
        Set<Role> set = userDto.getRoles();
        if ( set != null ) {
            user.setRoles( new HashSet<Role>( set ) );
        }

        return user;
    }

    @Override
    public UserDTO entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setStatus( user.getStatus() );
        userDTO.setCreatedDate( user.getCreatedDate() );
        userDTO.setPasswordDate( user.getPasswordDate() );
        byte[] profilePic = user.getProfilePic();
        if ( profilePic != null ) {
            userDTO.setProfilePic( Arrays.copyOf( profilePic, profilePic.length ) );
        }
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userDTO.setRoles( new HashSet<Role>( set ) );
        }

        return userDTO;
    }
}
