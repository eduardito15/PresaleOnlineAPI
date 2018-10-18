package com.presaleonline.presaleonlineapi.domain;

public enum UserType {
    PROVIDER("PROVIDER"),
    CLIENT("CLIENT");

    private final String text;

    /**
     * @param text
     */
    private UserType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
