import java.io.*;
import java.util.ArrayList;

public class CsvFileUtil {

    public static void saveInfoToCsv(ArrayList<User> userInfo) {
        // save file as "result.csv"
        String FilePath = "result.csv";
        File file = new File(FilePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //create a buffered writer to write message to file
        BufferedWriter writeText = null;
        try {
            writeText = new BufferedWriter(new FileWriter(FilePath, false));

            // write header, split by
            writeText.append("firstName, lastName, age, income, married, children, brotherSister, singleParent, disability, " +
                    "education, elderlyCare, loanInterest, retirement, mpf, tax");
            writeText.newLine();

            // write user info into the file
            for (User user : userInfo){   // enhanced for loop
                writeText.append(user.toString());
                writeText.newLine();
            }
            writeText.flush(); // write the info into the file
            writeText.close(); // close

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
