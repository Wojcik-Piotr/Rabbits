import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maleCount = scanner.nextInt();
        int femaleCount = scanner.nextInt();
        long limit = scanner.nextLong();

        Simulation simulation = new Simulation(maleCount, femaleCount, limit);
        System.out.println(simulation.simulate());
    }
}
