package com.sub.board.service;

import com.sub.board.dto.Users;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
  // user 등록
  public int insert(Users user) throws Exception;

  // 조회
  public Users select(int userNo) throws Exception;

  // 로그인
  public void login(Users user, HttpServletRequest request) throws Exception;

  // 수정
  public int update(Users user) throws Exception;

  // 삭제
  public int delete(String email) throws Exception;
}
