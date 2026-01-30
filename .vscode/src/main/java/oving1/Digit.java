package oving1;

public class Digit {
    private int tallsystem;
    private int sifferVerdi;



    public Digit(int tallsystem, int sifferVerdi) { // Konduktør. idk
        this.tallsystem = tallsystem;
        this.sifferVerdi = sifferVerdi; 
    }

    public boolean isValidInt() {
        if (sifferVerdi > -1) {
            if (sifferVerdi < tallsystem) {
                return true;
            }
            else if (sifferVerdi > tallsystem) {
                return false;
            }
        }

        else {
            return false;
        }

    }

    // Returnerer siffer-verdien
    public int getValue() { 
        return sifferVerdi;
    }

    // plusser på sifferverdi, eller restarter når den når
    public boolean increment() {
        if (isValidInt()) {
            sifferVerdi ++;
            return false;

        else if (sifferVerdi == tallsystem){
            sifferVerdi = 0;
            return true;

        }
        }

        else {
            sifferVerdi = 0;
            return false;

        }
    
        public int getBase() {
            return tallsystem;
        }


    }

    public String verdiTilStreng() {
        if (sifferVerdi < 10) {
            String tallet = Integer.toString(sifferVerdi);
            return tallet;
        }
        else {
            int bokstav = (sifferVerdi - 10) + 65;
            char character = (char) bokstav;
            return String.valeuOf(character);
            }
        

    }



    public int getTallsystem() {
        return tallsystem;
    }

    public void setTallsystem(int tallsystem) {
        this.tallsystem = tallsystem;
    }

    public int getSifferVerdi() {
        return sifferVerdi;
    }

    public void setSifferVerdi(int sifferVerdi) {
        this.sifferVerdi = sifferVerdi;
    }

    public String toString(String verdiTilStreng) {
        verdiTilStreng = Integer.toString(getValue())
        return verdiTilStreng; //En type streng som skal representere hele Digit greien
    }

    public static void main(String[] args) {
        Digit digit = new Digit(1,10);

        System.out.println(digit);
    }

}
