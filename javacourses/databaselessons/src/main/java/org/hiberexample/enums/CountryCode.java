package org.hiberexample.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CountryCode {

    RU("Russia"),

    US("Unated States of America"),

    BL("Belarus"),

    KZ("Kazakhstan");

    private final String value;
}
