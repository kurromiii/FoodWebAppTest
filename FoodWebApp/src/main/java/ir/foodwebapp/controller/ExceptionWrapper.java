package ir.foodwebapp.controller;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.time.zone.ZoneRulesException;
import java.util.IllegalFormatPrecisionException;
import java.util.MissingFormatWidthException;

public class ExceptionWrapper {
    public static String getMessage(Exception e){
        e.printStackTrace();
        if (e instanceof SQLException){
            return "Error : sql\n";
        }else if (e instanceof ArithmeticException){
            return "Error : calculation\n" + e.getMessage();
        }else if (e instanceof ArrayIndexOutOfBoundsException){
            return "Error : Array index\n" + e.getMessage();
        }else if (e instanceof ClassNotFoundException){
            return "Error : Class\n" + e.getMessage();
        }else if (e instanceof NumberFormatException){
            return "Error : Number format\n" + e.getMessage();
        }else if (e instanceof MissingFormatWidthException){
            return "Error : \n" + e.getMessage();
        }else if (e instanceof IllegalFormatPrecisionException){
            return "Error : \n" + e.getMessage();
        }else if(e instanceof ValueException){
            return "Invalid Data \n" + e.getMessage();
        }else if(e instanceof SQLRecoverableException){
            return "Error : \n" + e.getMessage();
        }else if(e instanceof ZoneRulesException){
            return "Error : \n" + e.getMessage();
        }else if(e instanceof SQLSyntaxErrorException){
            return "Error : \n" + e.getMessage();
        }
        else {
            return "Unknown Error - Call Admin\n" + e.getMessage();
        }
    }
}
