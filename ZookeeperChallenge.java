package ZookeeperChallenge;

public class ZookeeperChallenge {
    public static void main(String[] args) throws Exception {
        java.io.File animalsFile = new java.io.File("arrivingAnimals.txt");
        java.io.File namesFile = new java.io.File("animalNames.txt");
        java.io.FileWriter writer = new java.io.FileWriter("zooPopulation.txt");

        java.util.Scanner animalScanner = new java.util.Scanner(animalsFile);
        java.util.Scanner nameScanner = new java.util.Scanner(namesFile);

        String arrivalDate = "2025-04-06";

        Animal[] animals = new Animal[100];
        int count = 0;

        while (animalScanner.hasNextLine() && nameScanner.hasNextLine()) {
            String line = animalScanner.nextLine();
            String name = nameScanner.nextLine();
            animals[count] = new Animal(line, name, arrivalDate);
            count++;
        }

        writer.write("Crow Habitat:\n");
        for (int i = 0; i < count; i++) {
            if (animals[i].species.equalsIgnoreCase("crow")) {
                writer.write(animals[i].toString() + "\n");
            }
        }

        writer.write("\nCat Habitat:\n");
        for (int i = 0; i < count; i++) {
            if (animals[i].species.equalsIgnoreCase("cat")) {
                writer.write(animals[i].toString() + "\n");
            }
        }

        writer.write("\nOwl Habitat:\n");
        for (int i = 0; i < count; i++) {
            if (animals[i].species.equalsIgnoreCase("owl")) {
                writer.write(animals[i].toString() + "\n");
            }
        }

        writer.write("\nWolf Habitat:\n");
        for (int i = 0; i < count; i++) {
            if (animals[i].species.equalsIgnoreCase("wolf")) {
                writer.write(animals[i].toString() + "\n");
            }
        }

        writer.close();
        animalScanner.close();
        nameScanner.close();

        System.out.println("Zoo population report created: zooPopulation.txt");
    }
}