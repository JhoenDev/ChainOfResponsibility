public class Client {
    public static void main(String[] args) {
        WasteChain organicContainer = new OrganicWasteContainer();
        WasteChain recyclableContainer = new RecyclableWasteContainer();
        WasteChain hazardousContainer = new HazardousWasteContainer();

        organicContainer.setNextChain(recyclableContainer);
        recyclableContainer.setNextChain(hazardousContainer);

        Waste plasticBottle = new Waste("recyclable", 5);
        Waste bananaPeel = new Waste("organic", 30);
        Waste toxicChemical = new Waste("hazardous", 20);
        Waste bigPlastic = new Waste("recyclable", 50);
        Waste unknownWaste = new Waste("radioactive", 10);

        organicContainer.dispose(plasticBottle);
        organicContainer.dispose(bananaPeel);
        organicContainer.dispose(toxicChemical);
        organicContainer.dispose(bigPlastic);
        organicContainer.dispose(unknownWaste);
    }
}
