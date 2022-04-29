public class App {
    public static void main(String[] args) throws Exception {
        Settings a = new Settings();

        a.loadFromTextFile("options/old_parameters.txt");

        System.out.println("\nA:\n" + a);

        a.saveToTextFile("options/new_parameters.txt");
        a.saveToBinaryFile("options/new_parameters - binary");

        Settings b = new Settings();
        b.loadFromTextFile("options/new_parameters.txt");
        System.out.println("\nA:\n" + b);

        Settings c = new Settings();
        c.loadFromTextFile("options/new_parameters - binary");
        System.out.println("\nC:\n" + c);
    }
}
