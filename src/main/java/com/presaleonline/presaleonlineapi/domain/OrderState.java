package com.presaleonline.presaleonlineapi.domain;

public enum OrderState {
    PENDING("Pendiente"),
    RECEIVED("Recibido"),
    DELIVERED("Entregado"),
    FINALIZED("Finalizado");

    private final String text;

    /**
     * @param text
     */
    private OrderState(final String text) {
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
