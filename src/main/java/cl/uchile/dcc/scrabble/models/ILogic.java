package cl.uchile.dcc.scrabble.models;

public interface ILogic {
    ILogic andBinary(ScrabbleBinary scrabbleBinary);
    ILogic andBool(ScrabbleBool scrabbleBool);
    ILogic and(ILogic iLogic);
    ILogic orBinary(ScrabbleBinary scrabbleBinary);
    ILogic orBool(ScrabbleBool scrabbleBool);
    ILogic or(ILogic iLogic);
}
