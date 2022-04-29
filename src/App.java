public class App {
    public static void main(String[] args) throws Exception {
        Settings a = new Settings();
        a.loadFromTextFile("options/old_parameters.txt");
        System.out.println("\n" + a);
        a.saveToTextFile("options/new_parameters.txt");
        a.saveToBinaryFile("options/new_parameters - binary.txt");

        Settings b = new Settings();
        b.loadFromTextFile("options/new_parameters - binary.txt");
        System.out.println("\n\nB:\n" + b);
    }
}
