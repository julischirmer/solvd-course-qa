package homework3;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static Logger logger = LogManager.getLogger(homework2.Main.class.getName());
    private static File myfile = new File ("src/main/resources/example.txt");
    public static void main(String[] args) throws IOException {


        String text = FileUtils.readFileToString(myfile, "UTF-8").toLowerCase();

        HashSet<String> set = new HashSet<>(Arrays.asList(text.split("")));

        logger.info(text.split(" ").length + " words " + set.size() + " unique words");
        countUniqueWords(text);

    }

    public static void countUniqueWords(String text) throws IOException {
        int quantity = 0;
        String[] words = text.split("[$&+,:;=?@#|'<>.-^*()%!]| |[0-9]|\n", 0);

        for (String word : words) {
            if (!StringUtils.isBlank(word) && StringUtils.countMatches(text, word) == 1) {
                quantity++;
            }
        }

        FileUtils.writeStringToFile(myfile, "Unique words in the example: " + quantity + " \n", "UTF-8", true);
        logger.info("Unique words : " + quantity);

    }

}
