package edu.hogwarts.data;

public class House implements HogwartsPerson {

    private final HouseOrigin name;
    private final String founder;
    private final String[] colors;

    private static final House gryffindor = new House(HouseOrigin.GRYFFINDOR, "Godric Gryffindor", "scarlet", "gold");
    private static final House hufflepuff = new House(HouseOrigin.HUFFLEPUFF, "Helga Hufflepuff", "yellow", "black");
    private static final House ravenclaw = new House(HouseOrigin.RAVENCLAW, "Rowena Ravenclaw", "blue", "silver");
    private static final House slytherin = new House(HouseOrigin.SLYTHERIN, "Salazar Slytherin", "green", "silver");
    private static final House unknown = new House();


    public House(HouseOrigin name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {
        this.name = HouseOrigin.UNKNOWN;
        this.founder = "Unknown";
        this.colors = new String[0];
    }

    public static House getGryffindor() {
        return gryffindor;
    }

    public static House getSlytherin() {
        return slytherin;
    }

    public static House getRavenclaw() {
        return ravenclaw;
    }

    public static House getHufflepuff() {
        return hufflepuff;
    }

    public static House getUnknown() {
        return unknown;
    }

    public HouseOrigin getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public String[] getColors() {
        return colors;
    }


    public boolean equalsHouse(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof House)){
            return false;
        }

        House objHosue = (House) object;

        if (this.name.equals(objHosue.name)) {
            return true;
        }

        return false;
    }


    public String toString() {
        StringBuilder colorString = new StringBuilder();
        if(colors.length > 0){
            for(String color : colors){
                colorString.append(color).append(", ");
            }
            colorString.replace(colorString.lastIndexOf(", "), colorString.length()-1, ".");
        }
        return "edu.hogwarts.data.House{\n" +
                " name: " + name + "\n" +
                " founder: " + founder + "\n" +
                " colors: " + colorString + "\n" +
                "}";
    }

}
