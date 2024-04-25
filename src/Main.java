import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static ApplicationLogger logger = new ApplicationLogger();

    public static void main(String[] args)
    {
        List<Customer> customers = new ArrayList<>();
        List<Payments> payments = new ArrayList<>();
        List<PaymentsWithCustemerData> pwcd = new ArrayList<>();

        File customerCSVPath = new File("C:\\Users\\kisri\\OneDrive\\Dokumentumok\\Egyetem\\4. semester\\Kooperativ_Feladat&Testek\\OTP_app\\src\\customer1.csv");
        File paymentsCSVPath = new File("C:\\Users\\kisri\\OneDrive\\Dokumentumok\\Egyetem\\4. semester\\Kooperativ_Feladat&Testek\\OTP_app\\src\\Payment1.csv");

        FileReader(customers, customerCSVPath, ",");
        FileReader(payments, paymentsCSVPath, ",");

        pwcd = Summer(customers, payments);

        var q1 = QuerySumAmountsByCustomer(pwcd);

        System.out.println(q1);

        FileWriter("src/report01.csv" ,q1, ",");




    }

    private static void FileWriter(String filename, List<SumAmount> list, String separator){
        String str = null;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(SumAmount s : list){
                str = s.toString(separator);
                writer.write(str);
                writer.newLine();
            }


            writer.close();
        } catch (IOException e) {
            logger.doLog(e, null);
            throw new RuntimeException(e);
        }
    }

    private static List<PaymentsWithCustemerData> Summer (List<Customer> customers, List<Payments> payments){
        List<PaymentsWithCustemerData> result = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++){
            for (int j = 0; j < payments.size(); j++){
                if(customers.get(i).getShopId().equals(payments.get(j).getShopId()) && customers.get(i).getCustomerId().equals(payments.get(j).getCustomerId())){
                    result.add(new PaymentsWithCustemerData(payments.get(j), customers.get(i).getName(), customers.get(i).getAddress()));
                }
            }
        }
        return result;
    }

    private static List<SumAmount> QuerySumAmountsByCustomer(List<PaymentsWithCustemerData> l){
        List<SumAmount> result = new ArrayList<>();

        for (PaymentsWithCustemerData p: l) {
            if(result.isEmpty()){
                result.add(new SumAmount(p.getName(), p.getAddress(), p.getAmount()));
            }
            boolean set = false;
            for (int j =  0; j < result.size(); j++) {
                SumAmount r = result.get(j);
                if (r.getName().equals(p.getName()) && r.getAddress().equals(p.getAddress())) {
                    r.setAmount(r.getAmount() + p.getAmount());
                    set = !set;
                }
            }
            if(!set)
                result.add(new SumAmount(p.getName(), p.getAddress(), p.getAmount()));
        }

        return result;
    }

    private static void FileReader(List elements, File path, String separator){
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        } catch (FileNotFoundException e) {
            logger.doLog(e, null);
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(separator);
            try {

                if (data.length == 4){
                    for (int i = 0; i < data.length; i++){
                        if(data[i].isEmpty()){
                            throw new EmptyStackException();
                        }
                        data[i] = data[i].trim();
                    }
                    elements.add(new Customer(data[0], data[1], data[2], data[3]));
                }
                else if (data.length == 7){
                    PaymentType pt = null;
                    for (int i = 0; i < data.length; i++){
                        if(i == 2 && !data[i].isEmpty()){
                            if(data[i].trim().equals("card"))
                                pt = PaymentType.CARD;
                            else if (data[i].trim().equals("transfer"))
                                pt = PaymentType.TRANSFER;
                            else
                                throw new RuntimeException("Invalid payment method type");
                        }
                        if ((i == 4 && pt == PaymentType.CARD) || (i == 5 && pt == PaymentType.TRANSFER)){
                            data[i] = null;
                        }
                        else if(data[i].isEmpty()){
                            throw new RuntimeException(String.format("Value was not defined at the %d. column", i+1));
                        }
                        if (data[i] != null)
                            data[i] = data[i].trim();
                    }

                    elements.add(new Payments(data[0], data[1], pt, Integer.parseInt(data[3]), data[4], data[5], data[6] ));
                }
                else {
                    throw new RuntimeException("Wrong number of columns");
                }
            } catch (Exception e){
                logger.doLog(e, data);
                System.out.println(e.getMessage() + "\n " + data[0] + data[1] + data[2] + data[3] + data[4] + data[5] + data[6] +"\n");
            }

        }
        scanner.close();
    }
}