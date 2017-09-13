package app.security

object SecurityConstants {
  val SECRET = "SecretToSignJWT"
  val EXPIRATION_TIME = 864000000 // 10 days
  val TOKEN_PREFIX = "Bearer "
  val HEADER_STRING = "Authorization"
  val SIGN_UP_URL = "/api/users/sign-up"
  val LOGIN_URL = "/api/login"
}
