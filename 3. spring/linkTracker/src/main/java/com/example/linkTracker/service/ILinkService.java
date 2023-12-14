package com.example.linkTracker.service;

import java.util.Map;

public interface ILinkService {
    int createlink(String url, String password);
    String redirectLink(int linkId, String password);
    void invalidateLink(int linkId);
    Map<String, Integer> getStadistics(int linkId);
}
