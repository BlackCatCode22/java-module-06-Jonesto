package ZookeeperChallenge;

public class Animal {
    String species;
    String sex;
    int age;
    String color;
    int weight;
    String origin;
    String name;
    String birthSeason;
    String birthday;
    String uniqueID;
    String habitat;
    String arrivalDate;

    static int numCrows = 0;
    static int numCats = 0;
    static int numOwls = 0;
    static int numWolves = 0;

    public Animal(String line, String name, String arrivalDate) {
        this.name = name;
        this.arrivalDate = arrivalDate;

        String[] parts = line.split(", ");
        String[] basic = parts[0].split(" ");
        age = Integer.parseInt(basic[0]);
        sex = basic[3];
        species = basic[4];
        birthSeason = parts[1].substring(10); // remove "born in "

        color = parts[2].substring(0, parts[2].indexOf(" color"));
        weight = Integer.parseInt(parts[3].split(" ")[0]);
        origin = parts[4];

        birthday = genBirthday();
        uniqueID = genUniqueID();
        habitat = species.substring(0,1).toUpperCase() + species.substring(1) + " Habitat";
    }

    public String genBirthday() {
        int birthYear = 2025 - age;
        String date = "01-01";

        if (birthSeason.equalsIgnoreCase("spring")) {
            date = "03-21";
        } else if (birthSeason.equalsIgnoreCase("summer")) {
            date = "06-21";
        } else if (birthSeason.equalsIgnoreCase("fall")) {
            date = "09-21";
        } else if (birthSeason.equalsIgnoreCase("winter")) {
            date = "12-21";
        }

        return birthYear + "-" + date;
    }

    public String genUniqueID() {
        String prefix = "";
        int number = 0;

        if (species.equalsIgnoreCase("crow")) {
            prefix = "Cr";
            number = ++numCrows;
        } else if (species.equalsIgnoreCase("cat")) {
            prefix = "Ca";
            number = ++numCats;
        } else if (species.equalsIgnoreCase("owl")) {
            prefix = "Ow";
            number = ++numOwls;
        } else if (species.equalsIgnoreCase("wolf")) {
            prefix = "Wo";
            number = ++numWolves;
        }

        if (number < 10) {
            return prefix + "0" + number;
        } else {
            return prefix + number;
        }
    }

    public String toString() {
        return uniqueID + "; " + name + "; birth date: " + birthday + "; " + color + " color; " + sex + "; " +
                weight + " pounds; from " + origin + "; arrived " + arrivalDate;
    }
}
