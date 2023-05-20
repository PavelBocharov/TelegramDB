package com.mar.telegram.db.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {

    private Long id;
    private Long userId;
    private List<Long> actionIds;

}
