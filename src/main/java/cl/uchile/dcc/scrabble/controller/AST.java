package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;

public class AST {
    public String type;
    OperableEntity operableEntity = null;
    public AST left;
    public AST right;

    public AST(String type){
        this.type = type;
    }

    public void setMainEntity(OperableEntity operableEntity){
        this.operableEntity = operableEntity;
    }

    public AST getLeft(){
        return left;
    }

    public AST getRight(){
        return right;
    }
    public void setLeft(AST left){
        this.left = left;
    }

    public void setRight(AST right){
        this.right = right;
    }

    public Constant evaluate(){
        if(type.equals("Add")){
            return (new Add(left.evaluate(), right.evaluate())).evaluate();
        } else if (type.equals("String")){
            return operableEntity.evaluate();
        }
        return null;
    }
}
