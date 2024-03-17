package com.sub.board.dto;

import java.util.List;

import lombok.Data;

@Data
public class Users {
  private int no;
  private String email;
  private String password;
  private String passwordCheck;
  private String name;


  // 권한 목록
  List<UserAuth> authList;

  public Users() {

  }

  public Users(Users user) {
    this.no = user.getNo();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.name = user.getName();
  }

  
}
