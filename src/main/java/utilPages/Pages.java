package utilPages;

public enum Pages {
    LOGIN_PAGE("https://lennertamas.github.io/portio/"),
    LANDING_PAGE("https://lennertamas.github.io/portio/landing.html"),
    LOGOUT_PAGE("https://lennertamas.github.io/portio/index.html"),
    CONTACT_PAGE("https://lennertamas.github.io/portio/contact/"),
    PROFILE_PAGE("https://lennertamas.github.io/portio/profile"),
    BLOG_PAGE("https://lennertamas.github.io/portio/blog/"),
    FACEBOOK("https://www.facebook.com/");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
