package com.example.board.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto extends BaseDto{

    private String title;

    private String content;

    private String writer;

    private int views;

}
