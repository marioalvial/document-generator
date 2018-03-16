package generator;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Generator {

    String document = "";
    private final boolean formatted;
    private final int NUMBER_OF_FIRST_DIGITS;

    Generator(boolean formatted, int numberOfFirstDigits) {
        this.formatted = formatted;
        this.NUMBER_OF_FIRST_DIGITS = numberOfFirstDigits;
    }

    public final String generate(){
        generateFirstDigits(NUMBER_OF_FIRST_DIGITS);
        generateLastDigits();
        if(formatted){
            format();
        }
        return this.document;
    }

    protected abstract void generateLastDigits();

    protected abstract void format();

    private int randomize() {
        return ThreadLocalRandom.current().nextInt(0, 10);
    }

    final void setDigit(int result) {
        int digit = result % 11;
        if (digit < 2) {
            this.document = this.document.concat(String.valueOf(0));
        } else {
            this.document = this.document.concat(String.valueOf(11 - digit));
        }
    }

    int calculateNumber(int value, char digit) {
        int number = Character.getNumericValue(digit);
        return number * value;
    }

    private void generateFirstDigits(int numberOfDigits) {
        for (int i = 0; i < numberOfDigits; i++) {
            int randomNumber = randomize();
            document = document.concat(String.valueOf(randomNumber));
        }
    }
}