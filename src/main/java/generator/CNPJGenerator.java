package generator;

public class CNPJGenerator extends DocumentGenerator {

    public CNPJGenerator() {
        super(12);
    }

    @Override
    protected void generateLastDigits() {
        final int[] PESOS_FIRST_DIGIT = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        final int[] PESOS_SECOND_DIGIT = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        generateDigit(PESOS_FIRST_DIGIT);
        generateDigit(PESOS_SECOND_DIGIT);
    }

    @Override
    protected void format() {
        StringBuilder stringBuilder = new StringBuilder(this.document);
        this.document = stringBuilder.insert(2, ".")
                .insert(6, ".")
                .insert(10, "/")
                .insert(15, "-")
                .toString();
    }

    private void generateDigit(int[] PESOS) {
        int result = 0;
        for (int i = 0; i < this.document.toCharArray().length; i++) {
            int peso = PESOS[i];
            char digit = this.document.toCharArray()[i];
            result += calculateNumber(peso, digit);
        }
        setDigit(result);
    }

}