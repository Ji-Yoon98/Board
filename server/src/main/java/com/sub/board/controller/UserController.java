package com.sub.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sub.board.dto.JoinDTO;
import com.sub.board.service.UserService;

@RestController
@ResponseBody
public class UserController {

    private final UserService joinService;

    public UserController(UserService joinService) {

        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {

        joinService.joinProcess(joinDTO);

        return "ok";
    }
}
