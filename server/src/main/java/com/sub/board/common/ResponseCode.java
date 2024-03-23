package com.sub.board.common;

public interface ResponseCode {

  /* Http Status - 200 */
  String SUCCESS = "SU";

  /* Http Status - 400 */
  
  // 유효성 검사 실패
  String VALIDATION_FAILED = "VF";

  // 중복된 아이디
  String DUPLICATE_ID = "DI";

  // 존재하지 않는 유저
  String NOT_EXISTED_USER = "NE";

  /* Http Status - 401  */

  // 로그인 실패
  String SING_IN_FAIL = "SF";

  // 인증 실패
  String AUTHORIZATION_FAILED = "AF";
  
  /* Http Status - 403 */

  // 권한 없음
  String NO_PERMISSION = "NP";

  /* Http Status - 500 */

  // DB error
  String DATABASE_ERROR = "DBE";
}
