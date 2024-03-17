package com.sub.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sub.board.dto.UserAuth;
import com.sub.board.dto.Users;

@Mapper
public interface UserMapper {
  // user 등록
  public int insert(Users user) throws Exception;

  // 조회
  public Users select(int userNo) throws Exception;

  // 사용자 인증(로그인)
  public Users login(String username);

  // 회원 권한 
  public int insertAuth(UserAuth userAuth) throws Exception;

  // 수정
  public int update(Users user) throws Exception;

  // 삭제
  public int delete(String email) throws Exception;

} 
