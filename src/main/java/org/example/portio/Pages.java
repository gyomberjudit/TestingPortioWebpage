package org.example.portio;

public enum Pages {

//enums for webpages
    LOGIN_PAGE("https://lennertamas.github.io/portio/"),
    LANDING_PAGE("https://lennertamas.github.io/portio/landing.html"),
    LOGOUT_PAGE("https://lennertamas.github.io/portio/index.html"),
    CONTACT_PAGE("https://lennertamas.github.io/portio/contact/"),
    PROFILE_PAGE("https://lennertamas.github.io/portio/profile");

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
