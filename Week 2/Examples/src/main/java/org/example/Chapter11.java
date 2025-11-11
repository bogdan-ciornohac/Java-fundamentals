package org.example;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class Chapter11 {
    public static void main(String[] args) {


    }

    public class AhChoo {
        static class SneezeException extends Exception {
        }

        static class SniffleException extends SneezeException {
        }

        public static void main(String[] args) {
            try {
                throw new SneezeException();
            } catch (SneezeException e) {
            } finally {
            }
        }
    }
}



