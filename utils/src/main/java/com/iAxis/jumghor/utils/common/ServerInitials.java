package com.iAxis.jumghor.utils.common;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 3:35 PM
 */
public enum ServerInitials {
    //server initials must be of - characters
    DEFAULT("default"),
    SUITE("suite"),
    COMMENT("comment");

    private final String serverName;

    ServerInitials(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

}
