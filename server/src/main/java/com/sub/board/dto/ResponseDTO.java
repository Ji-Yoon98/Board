package com.sub.board.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sub.board.common.ResponseCode;
import com.sub.board.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDTO {
  private String code;
  private String message;

  public static ResponseEntity<ResponseDTO> databaseError() {
    ResponseDTO responseBody = new ResponseDTO(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
  }
}
