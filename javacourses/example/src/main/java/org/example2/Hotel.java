package org.example2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Hotel {

    private String city;

    private String address;

    private boolean isOpened;
}
