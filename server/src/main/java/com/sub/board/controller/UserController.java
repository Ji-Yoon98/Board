package com.sub.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sub.board.dto.JoinDTO;
import com.sub.board.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@ResponseBody
@RequiredArgsConstructor
public class UserController {

    private final UserService joinService;

    @PostMapping("/join")
    public ResponseEntity<?> joinProcess(JoinDTO joinDTO) {

        joinService.joinProcess(joinDTO);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
