interface WasteChain {
    void setNextChain(WasteChain nextChain);

    void dispose(Waste waste);
}