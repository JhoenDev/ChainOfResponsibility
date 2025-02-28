class RecyclableWasteContainer implements WasteChain {
    private WasteChain nextChain;
    private int capacity = 50;
    private final int maxCapacity = 50;

    public void setNextChain(WasteChain nextChain) {
        this.nextChain = nextChain;
    }

    public void dispose(Waste waste) {
        if (waste.getType().equals("recyclable")) {
            if (capacity >= waste.getSize()) {
                capacity -= waste.getSize();
                System.out.println("Recyclable waste disposed. Capacity: " + capacity + "/" + maxCapacity + ".");
            } else {
                collectWaste();
            }
        } else if (nextChain != null) {
            nextChain.dispose(waste);
        } else {
            System.out.println("Container for " + waste.getType() + " waste not found.");
        }
    }

    private void collectWaste() {
        System.out.println("Recyclable container full, collecting waste. Capacity reset to 25.");
        capacity = 25;
    }
}