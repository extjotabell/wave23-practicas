package com.ejLinkTracker.ejLinkTracker.dto.request;
import com.ejLinkTracker.ejLinkTracker.entity.LinkTracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerDTO {
    private String url;
    private String password;
    private int count;

    public LinkTracker toEntity(){
        return new LinkTracker(
                null,
                url,
                password,
                count
        );
    }

}
