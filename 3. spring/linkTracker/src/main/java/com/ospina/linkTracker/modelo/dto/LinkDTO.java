package com.ospina.linkTracker.modelo.dto;

public class LinkDTO {
    private String originalURL;
    private String password;
    private int redirectCount;
    private boolean valid;

    public LinkDTO(String originalURL, String password, int redirectCount, boolean valid) {
        this.originalURL = originalURL;
        this.password = password;
        this.redirectCount = redirectCount;
        this.valid = valid;
    }

    public LinkDTO() {
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(int redirectCount) {
        this.redirectCount = redirectCount;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
