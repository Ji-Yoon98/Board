package com.sub.board.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.sub.board.dto.UserAuth;
import com.sub.board.dto.Users;
import com.sub.board.mapper.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private PasswordEncoder passwordEncoder;

  private UserMapper userMapper;

  private AuthenticationManager authenticationManager;

  /* user 등록 */
  @Override
  public int insert(Users user) throws Exception {
    
    // pw 암호화
    String password = user.getPassword();
    String encodePw = passwordEncoder.encode(password);
    user.setPassword(encodePw);

    // user 등록
    int result = userMapper.insert(user);

    if(result > 0) {
      UserAuth userAuth = new UserAuth();
      userAuth.setEmail(user.getEmail());
      userAuth.setAuth("ROLE_USER");

      result = userMapper.insertAuth(userAuth);

      if(user.getEmail().equals("admin@example.com")) {
        userAuth.setAuth("ROLE_ADMIN");
        result = userMapper.insertAuth(userAuth);
      }
    } 
    
    return result;
  }

  /* user 조회 */
  @Override
  public Users select(int userNo) throws Exception {
    return userMapper.select(userNo);
  }

  /* user 로그인 */
  @Override
  public void login(Users user, HttpServletRequest request) throws Exception {
    String username = user.getEmail();
    String password = user.getPassword();
    
    // id,pw 인증 토큰 생성
    UsernamePasswordAuthenticationToken token
      = new UsernamePasswordAuthenticationToken(username, password);

    // 토큰에 요청 정보 등록
    token.setDetails(new WebAuthenticationDetails(request));

    // 토큰 이용 인증 요청 - 로그인
    Authentication authentication = authenticationManager.authenticate(token);
    
    log.info("인증 :: " + authentication.isAuthenticated());

    User authUser = (User) authentication.getPrincipal();

    log.info("인증된 id:: " + authUser.getUsername());

    // 인증된 사용자 등록
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  /* user 수정 */
  @Override
  public int update(Users user) throws Exception {

    // pw 암호화
    String password = user.getPassword();
    String encodePw = passwordEncoder.encode(password);
    user.setPassword(encodePw);

    int result = userMapper.update(user);

    return result;
  }

  /* user 삭제 */
  @Override
  public int delete(String email) throws Exception {
    return userMapper.delete(email);
  }
  
}
