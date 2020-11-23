package com.example.calculadoraalexsastre;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolverFormula {

    /*
        Resuelve una expresion matematica por medio de una Expresion Regular.
     */
    private String resolver(String expresionMatematica, char operador) {

        expresionMatematica = expresionMatematica.trim();
        /*
        Significado de la expresion regular:
            - Comprueba si el primer numero es negativo decimal o positivo decimal o negativo o positivo.
            - Despues obtiene el operador que se usa.
            - Por ultimo comprueba el segundo numero igual que el primero.
         */
        Pattern p = Pattern.compile("([-]{1}[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|-[\\d]+|[\\d]+)(\\" + operador + ")(-[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|[\\d]+)");
        Matcher m = p.matcher(expresionMatematica);


        if ( m.find() ) {

            //obtenemos los numeros y el operador.
            double num1 = Double.parseDouble(m.group(1));
            char operacion = m.group(2).charAt(0);
            double num2 = Double.parseDouble(m.group(3));

            double resultado = 0;

            //se realiza la operacion correspondiente al operador obtenido en cada caso.
            switch (operacion) {
                case '/':
                    if (num2 == 0) {
                        return "ERRROR";
                    }   resultado = num1 / num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                default:
                    break;
            }
            String txtResultado = "0";
            //Comprobamos si el resultado termina en .0, si es asi se lo quitamos.
            if( Math.abs( resultado ) > 0 ){
                txtResultado = String.valueOf(resultado);
                if( (Math.abs( resultado )/(int)Math.abs( resultado )) == 1D){
                    //Eliminamos el .0
                    txtResultado = String.valueOf(resultado).replaceFirst("\\.0", "");
                }
            }

            expresionMatematica = m.replaceFirst( txtResultado );
        }
        return expresionMatematica;
    }


    /*
        Se encarga de realizar la multiplicacion o la division antes que la suma y resta.
     */
    public String resolverFormula( String formula ) {
        ResolverFormula er = new ResolverFormula();

        //Division y multiplica
        while( true ){
            int indiceDivision = formula.indexOf("/");
            int indiceMultiplica = formula.indexOf("*");

            if( indiceDivision == -1 && indiceMultiplica == -1){
                break;
            }else if( indiceDivision == -1 && indiceMultiplica >= 0){
                formula = er.resolver(formula, '*');
            }else if( indiceDivision >= 0 && indiceMultiplica == -1){
                formula = er.resolver(formula, '/');
            }else if( indiceMultiplica < indiceDivision ){
                formula = er.resolver(formula, '*');
            }else{
                formula = er.resolver(formula, '/');
            }
        }
        //Resta y Suma
        while( true ){
            int indiceResta = formula.indexOf("-",1);
            int indiceSuma = formula.indexOf("+");

            if( indiceResta == -1 && indiceSuma == -1){
                break;
            }else if( indiceResta == -1 && indiceSuma >= 0){
                formula = er.resolver(formula, '+');
            }else if( indiceResta >= 0 && indiceSuma == -1){
                formula = er.resolver(formula, '-');
            }else if( indiceSuma < indiceResta){
                formula = er.resolver(formula, '+');
            }else{
                formula = er.resolver(formula, '-');
            }
        }
        return formula;
    }

}
