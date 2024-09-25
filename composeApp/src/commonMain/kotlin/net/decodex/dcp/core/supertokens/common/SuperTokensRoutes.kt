package net.decodex.dcp.core.supertokens.common

object SuperTokensRoutes {
    const val EMAIL_EXISTS = "auth/signup/email/exists"
    const val PHONE_NUMBER_EXISTS = "auth/signup/phonenumber/exists"

    object EmailPassword {
        const val SIGN_IN = "auth/signin"
        const val SIGN_UP = "auth/signup"
        const val PASSWORD_RESET_TOKEN = "auth/user/password/reset/token"
        const val PASSWORD_RESET = "auth/user/password/reset"
        const val PASSWORD_CHANGE = "auth/user/password/change"
    }

    object EmailVerification {
        const val VERIFY_TOKEN = "auth/user/email/verify/token"
        const val VERIFY = "auth/user/email/verify"
        const val CHECK_VERIFIED = "auth/user/email/verify"
    }

    object Passwordless {
        const val SIGNUP_CODE = "auth/signinup/code"
        const val SIGNUP_CODE_RESEND = "auth/signinup/code/resend"
        const val SIGNUP_CODE_CONSUME = "auth/signinup/code/consume"
    }

    object Session {
        const val SIGN_OUT = "auth/signout"
        const val REFRESH = "auth/session/refresh"
        const val JWKS = "auth/jwt/jwks.json"
        const val OIDC = "auth/.well-known/openid-configuration"
    }

    object ThirdParty {
        const val SIGN_IN_UP = "auth/signinup"
        const val AUTH_URL = "auth/authorisationurl"
        const val CALLBACK_APPLE = "auth/callback/apple"
    }

    object Totp {
        const val GET_DEVICES = "auth/totp/device/list"
        const val CREATE_DEVICE = "auth/totp/device"
        const val REMOVE_DEVICE = "auth/totp/device/remove"
        const val VERIFY_DEVICE = "auth/totp/device/verify"
        const val VERIFY = "auth/totp/verify"
    }

    object Mfa {
        const val CHECK = "/mfa/info"
    }
}
