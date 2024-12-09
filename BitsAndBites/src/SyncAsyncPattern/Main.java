package SyncAsyncPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.CompletableFuture;

public class Main {

    /**
     * Read a text file synchronously
     */
    private static void readFileSync(String path){
        System.out.println("Reading file synchronously");
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("File read");
    }

    private static void readFileAsync(String path){
        System.out.println("Reading file asynchronously...");
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try(BufferedReader br = new BufferedReader(new FileReader(path))){
                Thread.sleep(2000);
                String line;
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        System.out.println("Doing some other work");
        future.join();
    }

    public static void main(String[] args) {
        readFileSync("BitsAndBites/src/SyncAsyncPattern/test.txt");
        readFileAsync("BitsAndBites/src/SyncAsyncPattern/test.txt");
    }
}
