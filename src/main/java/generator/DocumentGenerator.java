package generator;

import java.util.concurrent.ThreadLocalRandom;

public abstract class DocumentGenerator {

    String document = "";
    private final int NUMBER_OF_FIRST_DIGITS;

    DocumentGenerator(int numberOfFirstDigits) {
        this.NUMBER_OF_FIRST_DIGITS = numberOfFirstDigits;
    }

    public final String generate(){
        generateFirstDigits(NUMBER_OF_FIRST_DIGITS);
        generateLastDigits();
        return prepareForReturn();
    }

    private String prepareForReturn() {
        String generatedDocument = this.document;
        this.document = "";
        return generatedDocument;
    }

    public final String generateFormatted(){
        generateFirstDigits(NUMBER_OF_FIRST_DIGITS);
        generateLastDigits();
        format();
        return prepareForReturn();
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