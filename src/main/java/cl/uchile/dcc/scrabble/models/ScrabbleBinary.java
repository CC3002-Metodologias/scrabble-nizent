package cl.uchile.dcc.scrabble.models;

/**
 * This class represents a binary number and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleBinary extends AbstractNumber implements IEncodedInteger, ILogic {
    private String value;

    /**
     * Creates a new Binary number
     * @param value a String in 01 format
     */
    public ScrabbleBinary(String value){
        this.value = value;
    }

    /**
     * Returns the hash code of the class
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return value.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleBinary transformToScrabbleBinary() {
        return new ScrabbleBinary(this.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleInt transformToScrabbleInt() {
        return new ScrabbleInt(this.toInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleFloat transformToScrabbleFloat() {
        return new ScrabbleFloat(this.toInt());
    }

    @Override
    public IInteger sum(IInteger iInteger) {
        return iInteger.sumBinary(this);
    }

    @Override
    public IInteger subtract(IInteger iInteger) {
        return iInteger.subtractToBinary(this);
    }

    @Override
    public IInteger divideBy(IInteger iInteger) {
        return iInteger.divideToBinary(this);
    }

    @Override
    public IInteger multiplyBy(IInteger iInteger) {
        return iInteger.multiplyBinary(this);
    }

    @Override
    public INumber sumInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(this.toInt()+scrabbleInt.Value());
    }

    @Override
    public IInteger sumBinary(ScrabbleBinary scrabbleBinary) {
        return new ScrabbleInt(scrabbleBinary.toInt()+this.toInt()).transformToScrabbleBinary();
    }

    @Override
    public IInteger subtractToBinary(ScrabbleBinary scrabbleBinary) {
        return new ScrabbleInt(scrabbleBinary.toInt()-this.toInt()).transformToScrabbleBinary();
    }

    @Override
    public INumber subtractToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(scrabbleInt.Value()-this.toInt());
    }

    @Override
    public INumber divideToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt( scrabbleInt.Value()/this.toInt());
    }

    @Override
    public INumber multiplyInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(this.toInt()*scrabbleInt.Value());
    }

    @Override
    public IInteger divideToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()/this.toInt())).transformToScrabbleBinary();
    }

    @Override
    public IInteger multiplyBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()*this.toInt())).transformToScrabbleBinary();
    }

    /**
     * Transforms a binary string into an int
     * @return an int equivalent to the binary
     */
    public int toInt() {
        String binary = this.value;
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Transforms negative binaries that starts with 1 into an int
     * @param binary a binary string with 0s and 1s
     * @return the negative int
     */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /**
     * Transforms positive binaries that starts with 0 into an int
     * @param binary binary string with first character 0
     * @return the equivalent int
     */
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Transforms a char of 0 or 1 into an int equivalent
     * @param bit '0' or '1' char
     * @return 1 or 0 equivalent to char
     */
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * Returns the value of the Scrabble Binary
     * @return value
     */
    @Override
    public String Value() {
        return this.value;
    }

    /**
     * Set value of Scrabble Binary
     * @param value string with binary format
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public ScrabbleString transformToScrabbleString() {
        return new ScrabbleString(this.toString());
    }

    /**
     * Transform the value of the ScrabbleBinary to an String
     * @return the String containing the value
     */
    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public ILogic andBinary(ScrabbleBinary scrabbleBinary) {
        return new ScrabbleBinary(binaryStringAnd(this.value, scrabbleBinary.Value()));
    }

    private static String binaryStringAnd(String bin1, String bin2){
        String shortest = bin1.length() < bin2.length()? bin1 : bin2 ;
        String largest = bin1.length() >= bin2.length()? bin1 : bin2 ;
        StringBuilder result = new StringBuilder();

        for (int i = largest.length()-1; i >= 0; i--) {
            if(i>largest.length()-shortest.length()-1){
                result.insert(0, charAnd(shortest.charAt(i-largest.length()+shortest.length()), largest.charAt(i)));
            } else {
                result.insert(0,charAnd(shortest.charAt(0),largest.charAt(i)));
            }
        }
        return result.toString();
    }

    private static char charAnd(char bit1, char bit2){
        return (bit1 == '1') & (bit2 == '1')? '1' : '0';
    }

    @Override
    public ILogic andBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBinary(binaryStringAnd(this.value, boolToBinaryString(scrabbleBool.Value())));
    }

    private String boolToBinaryString(boolean bool){
        return bool? "1":"0";
    }

    @Override
    public ILogic and(ILogic iLogic) {
        return iLogic.andBinary(this);
    }

    @Override
    public ILogic orBinary(ScrabbleBinary scrabbleBinary) {
        return new ScrabbleBinary(binaryStringOr(scrabbleBinary.Value(),this.value));
    }

    private static String binaryStringOr(String bin1, String bin2){
        String shortest = bin1.length() < bin2.length()? bin1 : bin2 ;
        String largest = bin1.length() >= bin2.length()? bin1 : bin2 ;
        StringBuilder result = new StringBuilder();

        for (int i = largest.length()-1; i >= 0; i--) {
            if(i>largest.length()-shortest.length()-1){
                result.insert(0, charOr(shortest.charAt(i-largest.length()+shortest.length()), largest.charAt(i)));
            } else {
                result.insert(0,charOr(shortest.charAt(0),largest.charAt(i)));
            }
        }
        return result.toString();
    }

    private static char charOr(char bit1, char bit2){
        return bit1=='1' | bit2=='1' ? '1' : '0';
    }

    @Override
    public ILogic orBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBinary(binaryStringOr(this.value, boolToBinaryString(scrabbleBool.Value())));
    }

    @Override
    public ILogic or(ILogic iLogic) {
        return iLogic.orBinary(this);
    }
}
