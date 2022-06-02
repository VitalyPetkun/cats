package services;

public enum Url {

    EDUCATS_URL("educatsUrl");

    private String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
