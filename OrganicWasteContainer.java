class OrganicWasteContainer implements WasteChain {
    private WasteChain nextChain;
    private int capacity = 100;
    private final int maxCapacity = 100;

    public void setNextChain(WasteChain nextChain) {
        this.nextChain = nextChain;
    }

    public void dispose(Waste waste) {
        if (waste.getType().equals("organic")) {
            if (capacity >= waste.getSize()) {
                capacity -= waste.getSize();
                System.out.println("Organic waste disposed. Capacity: " + capacity + "/" + maxCapacity + ".");
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
        System.out.println("Organic container full, collecting waste. Capacity reset to 50.");
        capacity = 50;
    }
}