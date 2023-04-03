package org.example.portio;

public enum Pages {
    LOGIN_PAGE("https://lennertamas.github.io/portio/"),
    LANDING_PAGE("https://lennertamas.github.io/portio/landing.html"),
    LOGOUT_PAGE("https://lennertamas.github.io/portio/index.html");


    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
