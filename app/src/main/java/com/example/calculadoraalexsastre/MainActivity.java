package com.example.calculadoraalexsastre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARACION DE VARIABLES

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnSumar, btnRestar, btnMultiplicar, btnDividir, btnIgual, btnPorcentaje, btnRaiz, btnPunto, btnClear;

    private ImageButton delete;

    private String cadena, historial;

    private boolean signoMas, signoMenos, signoMultiplicar, signoDividir, signoPunto;

    private TextView tvEntrada, tvHistorial;

    private ResolverFormula resolverFormula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolverFormula = new ResolverFormula();

        tvEntrada = findViewById(R.id.textView_resultado);
        tvHistorial = findViewById(R.id.textViewHistorial);
        tvHistorial.setMovementMethod(new ScrollingMovementMethod());

        btnSumar = findViewById(R.id.buttonSumar);
        btnRestar = findViewById(R.id.buttonRestar);
        btnMultiplicar = findViewById(R.id.buttonMultiplicar);
        btnDividir = findViewById(R.id.buttonDividir);

        btnIgual = findViewById(R.id.buttonIgual);
        btnPorcentaje = findViewById(R.id.buttonPorcentaje);
        btnPunto = findViewById(R.id.buttonPunto);
        btnRaiz = findViewById(R.id.buttonRaiz);

        delete = findViewById(R.id.imageButton2);


        //----------------------------------------------- BOTONES DE LOS NUMEROS --------------------------------------------------------------
        /*
            A medida que los pulsas,
            escriben en el TextView una cadena de numeros.
        */

        btn0 = findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "0");
                signosAFalse(R.id.button0);
            }
        });

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "1");
                signosAFalse(R.id.button1);
            }
        });

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "2");
                signosAFalse(R.id.button2);
            }
        });

        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "3");
                signosAFalse(R.id.button3);
            }
        });

        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "4");
                signosAFalse(R.id.button4);
            }
        });

        btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "5");
                signosAFalse(R.id.button5);
            }
        });

        btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "6");
                signosAFalse(R.id.button6);
            }
        });

        btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "7");
                signosAFalse(R.id.button7);
            }
        });

        btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "8");
                signosAFalse(R.id.button8);
            }
        });

        btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                tvEntrada.setText(cadena + "9");
                signosAFalse(R.id.button9);
            }
        });


        // ------------------------------------------- BOTON CLEAR -----------------------------------------------------------------------------
        /*
            Limpia los dos TextView.
         */

        btnClear = findViewById(R.id.buttonC);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEntrada.setText("");
                tvHistorial.setText("");
                signosAFalse(R.id.buttonC);
            }
        });


        // ------------------------------------------ BOTONES OPERACIONES ---------------------------------------------------------------------
        /*
        Comprueban si la cadena no es nula y si no se han pulsado anteriormente.
        En ese caso, se comprueba si su ultimo caracter es un signo diferente, si lo es, lo cambia por el signo del boton pulsado.
        Si no se cumple lo primero, salta un Toast.
         */

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(signoMenos == false) {
                    if(cadena.endsWith("*") || cadena.endsWith("+") || cadena.endsWith("/")) {
                        cadena = cadena.substring(0, cadena.length()-1);
                        tvEntrada.setText(cadena);
                    }
                    tvEntrada.setText(cadena + "-");
                    signoMenos = true;
                    signosAFalse(R.id.buttonRestar);
                } else  {
                    Toast.makeText(getApplicationContext(),"Entrada no valida",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(cadena.length() > 0 && signoMas == false) {
                    if(cadena.endsWith("*") || cadena.endsWith("/") || cadena.endsWith("-")) {
                        cadena = cadena.substring(0, cadena.length()-1);
                        tvEntrada.setText(cadena);
                    }
                    tvEntrada.setText(cadena + "+");
                    signoMas = true;
                    signosAFalse(R.id.buttonSumar);
                } else {
                    Toast.makeText(getApplicationContext(),"Entrada no valida",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(cadena.length() > 0 && signoMultiplicar == false) {
                    if(cadena.endsWith("/") || cadena.endsWith("+") || cadena.endsWith("-")) {
                        cadena = cadena.substring(0, cadena.length()-1);
                        tvEntrada.setText(cadena);
                    }
                    tvEntrada.setText(cadena + "*");
                    signoMultiplicar = true;
                    signosAFalse(R.id.buttonMultiplicar);
                } else {
                    Toast.makeText(getApplicationContext(),"Entrada no valida",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(cadena.length() > 0 && signoDividir == false) {
                    if(cadena.endsWith("*") || cadena.endsWith("+") || cadena.endsWith("-")) {
                        cadena = cadena.substring(0, cadena.length()-1);
                        tvEntrada.setText(cadena);
                    }
                    tvEntrada.setText(cadena + "/");
                    signoDividir = true;
                    signosAFalse(R.id.buttonDividir);
                } else {
                    Toast.makeText(getApplicationContext(),"Entrada no valida",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //----------------------------------------------------- BOTON PUNTO -------------------------------------------------------------------------
        /*
        Convierte el numero en decimal añadiendole un punto.
         */

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(!cadena.endsWith(".") || cadena.length() > 0) {
                    tvEntrada.setText(cadena + ".");
                    signoPunto = true;
                    signosAFalse(R.id.buttonPunto);
                } else {
                    Toast.makeText(getApplicationContext(),"Entrada no valida",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //------------------------------------------------------- BOTON DELETE ----------------------------------------------------------------------
        /*
        Borra los carecteres de la cadena uno a uno.
        Si se mantiene pulsado tiene la misma funcion que el clear.
         */

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                if(cadena.length() != 0) {
                    tvEntrada.setText(cadena.substring(0, cadena.length()-1));
                    signosAFalse(R.id.imageButton2);
                } else {
                    Toast.makeText(getApplicationContext(), "No hay numeros", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvEntrada.setText("");
                cadena = "";
                signosAFalse(R.id.imageButton2);
                return true;
            }
        });


        //---------------------------------------------------- BOTON IGUAL --------------------------------------------------------------------------
        /*
        Llama al metodo resolverFormula() de la clase ResolverFormula
        y saca el resultado de la cadena introducida.
         */

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                historial = tvHistorial.getText().toString();

                if( cadena.trim().length() > 0 ) {
                    String resultado = resolverFormula.resolverFormula(cadena.trim());
                    tvEntrada.setText(resultado);
                    tvHistorial.setText(historial + cadena + "=\n" + resultado + "\n ------------------------------------------------\n");
                    autoScroll();
                } else
                    Toast.makeText(getApplicationContext(), "Inserta numeros.", Toast.LENGTH_SHORT).show();
            }
        });


        //----------------------------------------------------- BOTON RAIZ ---------------------------------------------------------------------------
        /*
        Calcula la raiz cuadrada de un numero.
        Solo admite un numero.
         */

        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                historial = tvHistorial.getText().toString();

                if(cadena.trim().length() > 0 && !cadena.contains("+") && !cadena.contains("-") && !cadena.contains("*") && !cadena.contains("/") ) {
                    double resultado = Double.parseDouble(cadena);
                    tvEntrada.setText(String.valueOf(Math.sqrt(resultado)));
                    tvHistorial.setText(historial + "√" + cadena + " =\n" + Math.sqrt(resultado) + "\n ------------------------------------------------\n");
                    autoScroll();
                    signosAFalse(R.id.buttonRaiz);
                } else {
                    Toast.makeText(getApplicationContext(), "Solo un numero.",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //--------------------------------------------------------- BOTON PORCENTAJE --------------------------------------------------------------------
        /*
        Divide el numero introducido entre 100.
        Solo admite un numero.
         */

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = tvEntrada.getText().toString();
                historial = tvHistorial.getText().toString();

                if(cadena.trim().length() > 0 && !cadena.contains("+") && !cadena.contains("-") && !cadena.contains("*") && !cadena.contains("/") ) {
                    double resultado = Double.parseDouble(cadena) / 100;
                    tvEntrada.setText(String.valueOf(resultado));
                    tvHistorial.setText(historial + "%" + cadena + " =\n" + resultado + "\n ------------------------------------------------\n");
                    autoScroll();
                    signosAFalse(R.id.buttonPorcentaje);
                } else if(cadena.startsWith("-")) {
                    double resultado = Double.parseDouble(cadena) / 100;
                    tvEntrada.setText(String.valueOf(resultado));
                    tvHistorial.setText(historial + "%" + cadena + " =\n" + resultado + "\n ------------------------------------------------\n");
                    autoScroll();
                    signosAFalse(R.id.buttonPorcentaje);
                } else {
                    Toast.makeText(getApplicationContext(), "Solo un numero.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //------------------------------------------------ METODOS ADICIONALES ------------------------------------------------------------------------------

    public void signosAFalse( int idBotonActual) {

        if(idBotonActual != R.id.buttonRestar) {
            signoMenos = false;
        }

        if(idBotonActual != R.id.buttonSumar) {
            signoMas = false;
        }

        if(idBotonActual != R.id.buttonMultiplicar) {
            signoMultiplicar = false;
        }

        if(idBotonActual != R.id.buttonDividir) {
            signoDividir = false;
        }

        if(idBotonActual != R.id.buttonRestar || idBotonActual != R.id.buttonSumar || idBotonActual != R.id.buttonMultiplicar || idBotonActual != R.id.buttonDividir) {
            signoPunto = false;
        }
    }

    protected void autoScroll () {
        tvHistorial = findViewById(R.id.textViewHistorial);
        // Descubrimos cuanto scroll hay que hacer. Le pedimos la posicion de la ultima linea y le quitamos la altura
        final int scrollAmount = tvHistorial.getLayout().getLineTop(tvHistorial.getLineCount()) - tvHistorial.getHeight();
        // Si no hay que hacer scroll sera <=0
        if (scrollAmount > 0)
            tvHistorial.scrollTo(0, scrollAmount);
        else
            tvHistorial.scrollTo(0, 0);
    }



}