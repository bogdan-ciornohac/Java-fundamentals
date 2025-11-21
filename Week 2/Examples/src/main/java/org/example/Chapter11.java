package org.example;




public class Chapter11 {
    public static void main(String[] args) {

        String s = ("hello" + new String("world"));
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



