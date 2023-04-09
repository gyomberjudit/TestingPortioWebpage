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
    UX_CASE_STUDY_PAGE("https://lennertamas.github.io/portio/portfolio/ux-case-study-for-agriculture-app/"),
    RECIPE_APP_PAGE("https://lennertamas.github.io/portio/portfolio/recipe-app-ux-study/");

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
