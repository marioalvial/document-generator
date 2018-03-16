package generator;

public class CPFGenerator extends Generator {

    public CPFGenerator(boolean formatted) {
        super(formatted, 9);
    }

    @Override
    protected void generateLastDigits() {
        final int COUNT_FIRST_DIGIT = 10;
        final int COUNT_SECOND_DIGIT = 11;
        generateDigit(COUNT_FIRST_DIGIT);
        generateDigit(COUNT_SECOND_DIGIT);
    }

    @Override
    protected void format() {
        StringBuilder stringBuilder = new StringBuilder(this.document);
        this.document = stringBuilder.insert(3, ".")
                .insert(7, ".")
                .insert(11, "-")
                .toString();
    }

    private void generateDigit(int count) {
        int result = 0;
        for (char digit : this.document.toCharArray()) {
            result += calculateNumber(count, digit);
            count--;
        }
        setDigit(result);
    }

}
