
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class Settings {
    HashMap<String, Integer> settingsTable;

    Settings() {
        settingsTable = new HashMap<>();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String nameParameter : settingsTable.keySet()) {
            str.append(nameParameter + " ");
            str.append(settingsTable.get(nameParameter) + "\n");
        }
        return str.toString();
    }

    public void put(String nameParameter, int value) {
        settingsTable.put(nameParameter, value);
    }

    public int get(String nameParameter) {
        return settingsTable.get(nameParameter);
    }

    public void delete(String nameParameter) {
        settingsTable.remove(nameParameter);
    }

    public void loadFromTextFile(String filename) throws IOException {
        String name;
        int value;

        File textFile = new File(filename);
        Scanner fileReader = new Scanner(textFile);

        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();

            int index = data.indexOf(" ");
            name = data.substring(0, index);
            value = Integer.parseInt(data.substring(index + 1));

            settingsTable.put(name, value);
        }
        fileReader.close();
    }

    public void saveToTextFile(String filename) throws IOException {
        File textFile = new File(filename);

        if (textFile.createNewFile())
            System.out.println("File created: " + textFile.getName());
        else
            System.out.println("File already exists.");

        FileWriter myWriter = new FileWriter(filename);
        myWriter.write(this.toString());
        myWriter.close();
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        loadFromTextFile(filename);
    }

    public void saveToBinaryFile(String filename) throws IOException {
        FileOutputStream binaryFile = new FileOutputStream(new File(filename));
        BufferedOutputStream binaryWriter = new BufferedOutputStream(binaryFile);
        
        binaryWriter.write(this.toString().getBytes());
        binaryWriter.flush();
        binaryFile.close();
    }
}
