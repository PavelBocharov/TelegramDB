package com.mar.telegram.db.controller;

import com.mar.telegram.db.dto.PostInfoDto;
import com.mar.telegram.db.jpa.PostInfoRepository;
import com.mar.telegram.db.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController()
@RequestMapping(value = "/postinfo")
public class PostController {

    @Autowired
    private PostInfoRepository postInfoRepository;

    private PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    @GetMapping(value = "/isNotSend")
    public Mono<PostInfoDto> getPostBySendFlag() {
        return Mono.justOrEmpty(postInfoRepository.getByIsSend(false))
                .map(postMapper::mapToDto);
    }

    @GetMapping(value = "/{chatId}/{messageId}")
    public Mono<PostInfoDto> getPostBySendFlag(@PathVariable Long chatId, @PathVariable Integer messageId) {
        return Mono.justOrEmpty(postInfoRepository.getByChatIdAndMessageId(chatId, messageId))
                .map(postMapper::mapToDto);
    }

    @PostMapping(value = "")
    public Mono<PostInfoDto> create(@RequestBody PostInfoDto postInfoDto) {
        return Mono.justOrEmpty(postMapper.mapToEntity(postInfoDto))
                .map(postInfoRepository::save)
                .map(postMapper::mapToDto);
    }

}
