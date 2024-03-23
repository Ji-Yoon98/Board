package com.sub.board.common;

public interface ResponseMessage {
  /* Http Status - 200 */
  String SUCCESS = "Success";

  /* Http Status - 400 */
  
  // 유효성 검사 실패
  String VALIDATION_FAILED = "Validation failed.";

  // 중복된 아이디
  String DUPLICATE_ID = "Duplicate id.";

  // 존재하지 않는 유저
  String NOT_EXISTED_USER = "This user does not exist.";

  /* Http Status - 401  */

  // 로그인 실패
  String SING_IN_FAIL = "Login information mismatch.";

  // 인증 실패
  String AUTHORIZATION_FAILED = "Authorization Failed.";
  
  /* Http Status - 403 */

  // 권한 없음
  String NO_PERMISSION = "Do not have permission.";

  /* Http Status - 500 */

  // DB error
  String DATABASE_ERROR = "Database error.";
}
