class HazardousWasteContainer implements WasteChain {
    private WasteChain nextChain;
    private int capacity = 25;
    private final int maxCapacity = 25;

    public void setNextChain(WasteChain nextChain) {
        this.nextChain = nextChain;
    }

    public void dispose(Waste waste) {
        if (waste.getType().equals("hazardous")) {
            if (capacity >= waste.getSize()) {
                capacity -= waste.getSize();
                System.out.println("Hazardous waste disposed. Capacity: " + capacity + "/" + maxCapacity + ".");
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
        System.out.println("Hazardous container full, collecting waste. Capacity reset to 12.");
        capacity = 12;
    }
}