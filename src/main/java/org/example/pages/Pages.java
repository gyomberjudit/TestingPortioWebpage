package org.example.pages;

public enum Pages {
    LOGIN_PAGE("https://lennertamas.github.io/portio/"),
    LANDING_PAGE("https://lennertamas.github.io/portio/landing.html"),
    LOGOUT_PAGE("https://lennertamas.github.io/portio/index.html"),
    CONTACT_PAGE("https://lennertamas.github.io/portio/contact/"),
    PROFILE_PAGE("https://lennertamas.github.io/portio/profile"),
    RECIPE_APP_PAGE("https://lennertamas.github.io/portio/portfolio/recipe-app-ux-study/"),
    BLOG_PAGE("https://lennertamas.github.io/portio/blog/"),
    FACEBOOK("https://www.facebook.com/"),
    LINKEDIN("https://www.linkedin.com/");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
