package com.example.board.demo.controller;

import com.example.board.demo.dao.BoardDaoImpl;
import com.example.board.demo.dto.BoardDto;
import com.example.board.demo.service.BoardServiceImpl;
import com.example.board.demo.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/board")
public class BoardController {

    private final IBoardService boardService;

    @Autowired
    public BoardController(BoardServiceImpl boardService){
        this.boardService = boardService;
    }

    @GetMapping
    public String goBoard(){

        return "board";
    }

    @PostMapping
    public @ResponseBody Map<String, Object> createBoard(BoardDto boardDto){
        Map<String, Object> resultMap = new HashMap<String,Object>();

        try{
            boardDto.setRegpeId("hoon");
            boardDto.setModpeId("hoon");
            boardService.createBoard(boardDto);
            resultMap.put("resultCode", "success");
            resultMap.put("resultMsg", "게시글 작성이 완료되었습니다.");
        } catch(RuntimeException e){
            e.printStackTrace();
            resultMap.put("resultCode", "fail");
            resultMap.put("resultMsg", "게시글 작성이 실패하였습니다.");
        }

        return resultMap;
    }

}
