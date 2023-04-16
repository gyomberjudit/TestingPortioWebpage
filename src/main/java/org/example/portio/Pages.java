package org.example.portio;

public enum Pages {

//enums for webpages
    LOGIN_PAGE("https://lennertamas.github.io/portio/"),
    LANDING_PAGE("https://lennertamas.github.io/portio/landing.html"),
    LOGOUT_PAGE("https://lennertamas.github.io/portio/index.html"),
    CONTACT_PAGE("https://lennertamas.github.io/portio/contact/"),
    PROFILE_PAGE("https://lennertamas.github.io/portio/profile"),
    CASE_STUDY_PAGE("https://lennertamas.github.io/portio/portfolio/case-study-one/"),
    EVENT_APP_CASE_STUDY("https://lennertamas.github.io/portio/portfolio/event-app-case-study/"),
    RECIPE_APP_PAGE("https://lennertamas.github.io/portio/portfolio/recipe-app-ux-study/"),
    BLOG_PAGE("https://lennertamas.github.io/portio/blog/"),
    TERMS_AND_CONDITIONS("https://lennertamas.github.io/portio/tc.html"),
    FACEBOOK("https://www.facebook.com/"),
    LINKEDIN("https://www.linkedin.com/"),
    PINTEREST("https://www.pinterest.com/"),
    TWITTER("https://twitter.com/");

    private final String url;

//constructor
    Pages(String url) {
        this.url = url;
    }

//getter for urls
    public String getUrl() {
        return url;
    }
}
