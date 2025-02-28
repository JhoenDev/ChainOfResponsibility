class Waste {
    private String type;
    private int size;

    public Waste(String type, int size) {
        this.type = type.toLowerCase(); // Normalize to lowercase for case insensitivity
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}