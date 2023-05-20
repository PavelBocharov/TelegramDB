package com.mar.telegram.db.controller;

import com.mar.telegram.db.dto.UserDto;
import com.mar.telegram.db.entity.UserInfo;
import com.mar.telegram.db.jpa.UserInfoRepository;
import com.mar.telegram.db.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @GetMapping(value = "/uid/{userId}")
    public Mono<UserDto> getUserById(@PathVariable Long userId) {
        return Mono
                .justOrEmpty(userInfoRepository.getByUserId(userId))
                .map(userMapper::mapToDto);
    }

    @GetMapping(value = "/create/uid/{userId}")
    public Mono<UserDto> createUserWithUId(@PathVariable Long userId) {
        return Mono
                .just(userInfoRepository.save(UserInfo.builder().userId(userId).build()))
                .map(userMapper::mapToDto);
    }

}
