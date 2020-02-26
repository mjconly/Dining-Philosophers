public class Philosopher implements Runnable {
    private int id;
    private Fork left;
    private Fork right;

    public Philosopher(int id, Fork left, Fork right){
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public void run(){
        while (true){
            try{
                String name = "Philospher " + this.id;
                System.out.println(name + " is thinking...");
                Thread.sleep((int) (Math.random() * 2000));

                synchronized (this.left){
                    System.out.println(name + " using left fork" + this.left.getLabel());

                    synchronized (this.right){
                        System.out.println(name + " using right fork " + this.right.getLabel());

                        Thread.sleep((int) Math.random() * 2000);

                        System.out.println(name + " put down right fork " + this.right.getLabel());
                    }

                    System.out.println(name + " put down left fork " + this.left.getLabel());
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
