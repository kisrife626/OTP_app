import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        List<Customer> customers = new ArrayList<>();
        List<Payments> payments = new ArrayList<>();

        File customerCSVPath = new File("C:\\Users\\kisri\\OneDrive\\Dokumentumok\\Egyetem\\4. semester\\Kooperativ_Feladat&Testek\\OTP_app\\src\\customer1.csv");
        String paymentsCSVPath = "payments.csv";

        FileReader(customers, customerCSVPath);
//        FileReader(payments, paymentsCSVPath);

//        for (var customer : customers){
//            System.out.println(customer.getName());
//        }
    }

    private static void FileReader(List elements, File path){
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] data = line.split(",");
            try {
                if (data.length != 4){
                    throw new RuntimeException("Wrong number of columns");
                }
                elements.add(new Customer(data[0], data[1], data[2], data[3]));
            } catch (Exception e){

            }

        }
        scanner.close();
    }
}