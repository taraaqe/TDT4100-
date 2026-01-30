package oving1;

public class UpOrDownCounter {

    // felt
    private int counter;
    private int end;

    // konduktør
    public UpOrDownCounter(int start, int end) {
        this.counter = start;
        this.end = end;
    }

    public UpOrDownCounter(int start, int end, int mid) {
        this.counter = start;
        this.end = end;
    }

    /*
     * Metoder
     * Skal lage noe som gjør at start og slutt verdi ikke er samme
     */
    public boolean isValidInt() {
        if (counter == end ) {
            return false;
        }

        return true;
    }

    public int getCounter() {
        return counter;
    }

    public boolean count() {
        if (isValidInt()) {
            if (counter < end) {
                counter++;
                
                if (isValidInt()) {
                    return true;

                }
                else {
                    return false;
                }
            }

            else if (counter > end) {
                counter--;
                
                if (isValidInt()) {
                    return true;

                }
                else {
                    return false;
                }

            }

            else {
                return false;
            }
        }

        else {
            return false;
        }
        

    }

    // toString
    public String toString() {
        return "counter: " + counter + ", end: " + end;
    }

    public static void main(String[] args) {
        UpOrDownCounter upOrDownCounter = new UpOrDownCounter(1, -5);

       
        for (int i = 0; i > -5; i--) {
            upOrDownCounter.count();
        }
        boolean result = upOrDownCounter.count();

        System.out.println(result);
        System.out.println(upOrDownCounter.count());
    }
}
