public class Main {

    public static void main(String[] args) {
        String[] labels = {"A", "B", "C", "D", "E"};
        Fork[] forks = new Fork[5];

        for (int i = 0; i < 5; i++){
            Fork f = new Fork(labels[i]);
            forks[i] = f;
        }

        for (int i = 0; i < 5; i++){
            Philosopher p;
            if (i - 1 < 0){
                p = new Philosopher(i, forks[i], forks[4]);
            }
            else{
                p = new Philosopher(i, forks[i], forks[i - 1]);
            }

            new Thread(p).start();
        }
    }
}
