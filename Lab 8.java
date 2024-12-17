class CollegeThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CseThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Main{

    public static void main(String[] args) {
       
        CollegeThread collegeThread = new CollegeThread();
        CseThread cseThread = new CseThread();

        collegeThread.start();
        cseThread.start();
    }
}

