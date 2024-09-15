package net.decodex.dcp.core.supertokens.recipes.core

import net.decodex.dcp.core.supertokens.SuperTokensClient
import net.decodex.dcp.core.supertokens.common.RECIPE_EMAIL_PASSWORD
import net.decodex.dcp.core.supertokens.common.RECIPE_PASSWORDLESS
import net.decodex.dcp.core.supertokens.recipes.emailpassword.EmailPasswordRecipe
import net.decodex.dcp.core.supertokens.recipes.passwordless.PasswordlessRecipe

suspend fun SuperTokensClient.checkEmailExists(
    email: String,
    recipeId: String = RECIPE_EMAIL_PASSWORD,
): Boolean {
    return when (recipeId) {
        RECIPE_EMAIL_PASSWORD -> getRecipe<EmailPasswordRecipe>().checkEmailExists(email = email)
        RECIPE_PASSWORDLESS -> getRecipe<PasswordlessRecipe>().checkEmailExists(email = email)
        else -> throw IllegalArgumentException("Only EmailPassword and Passwordless recipes are allowed")
    }
}
