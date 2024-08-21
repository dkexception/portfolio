package io.github.dkexception.portfolio.domain

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ic_github
import portfolio.composeapp.generated.resources.ic_linkedin
import portfolio.composeapp.generated.resources.ic_medium

data class SocialLinkData(
    val icon: DrawableResource,
    val destinationUrl: String,
    val contentDescription: String? = null
) {
    companion object {
        val DEFAULT = listOf(
            SocialLinkData(
                icon = Res.drawable.ic_linkedin,
                destinationUrl = "https://www.linkedin.com/in/dkexception",
                contentDescription = "Dhanesh's LinkedIn profile"
            ),
            SocialLinkData(
                icon = Res.drawable.ic_github,
                destinationUrl = "https://github.com/dkexception",
                contentDescription = "Dhanesh's Github profile"
            ),
            SocialLinkData(
                icon = Res.drawable.ic_medium,
                destinationUrl = "https://dkexception.medium.com/",
                contentDescription = "Dhanesh's Medium profile"
            )
        )
    }
}
