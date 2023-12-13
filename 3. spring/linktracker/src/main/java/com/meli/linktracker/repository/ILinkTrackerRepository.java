package com.meli.linktracker.repository;

import com.meli.linktracker.entity.Link;

public interface ILinkTrackerRepository {

    Link createLink(String linkId, String url, String password);

    Link getLink(String linkId);

}
