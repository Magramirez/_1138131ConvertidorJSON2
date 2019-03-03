package com.edu.mx.practica.uno.gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements ActionListener {

    private JTextArea entrada;
    private JTextArea salida;
    private JButton boton;
    private JComboBox seleccion;
    private JPanel panel;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    Convertidor metodos;

    Border border = BorderFactory.createLineBorder(Color.BLACK,1);

    public Ventana() {

        //Se declaran elementos que se utilizaran en el codigo
        entrada = new JTextArea();
        salida = new JTextArea();
        boton = new JButton("Convertir");
        seleccion = new JComboBox();
        panel = new JPanel();
        metodos = new Convertidor();
        panel.setLayout(null);

        scroll1 = new JScrollPane(entrada);
        scroll1.setBounds(20,60,250,400);
        scroll1.setBorder(border);
        scroll1.setVerticalScrollBarPolicy(20);
        scroll1.setHorizontalScrollBarPolicy(30);

        salida.setEditable(false);
        scroll2 = new JScrollPane(salida);
        scroll2.setBounds(500,60,250,400);
        scroll2.setBorder(border);
        scroll2.setVerticalScrollBarPolicy(20);
        scroll2.setHorizontalScrollBarPolicy(30);

        boton.setBounds(335,220,100,40);

        seleccion.addItem("XML");
        seleccion.addItem("JAVA");
        seleccion.setBounds(70,470,150,30);

        panel.add(scroll1);
        panel.add(scroll2);
        panel.add(boton);
        panel.add(seleccion);

        boton.addActionListener(this);

        this.add(panel);
        this.setSize(new Dimension(800,650));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String textoE = entrada.getText();
        String textoS;
        if(textoE.trim().length() == 0)
            JOptionPane.showMessageDialog(this,"No hay texto","Texto vacío", JOptionPane.WARNING_MESSAGE);
        else {
            if(seleccion.getSelectedItem().toString() == "XML" && textoE.charAt(0) == '<') {
                textoS = metodos.convertidorXML(textoE);
                if(textoS == "no")
                    JOptionPane.showMessageDialog(this,"Ingrese de nuevo","Formato incorrecto", JOptionPane.WARNING_MESSAGE);
                else
                    salida.setText(textoS);
            }
            if(seleccion.getSelectedItem().toString() == "JAVA") {
                textoS = metodos.convertidorJAVA(textoE);
                if (textoS == "no")
                    JOptionPane.showMessageDialog(this,"Ingrese de nuevo","Formato incorrecto", JOptionPane.WARNING_MESSAGE);
                else
                    salida.setText(textoS);
            }
        }
    }
}


//Otras maneras de intentar hacer el codigo

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*public class Ventana extends JFrame implements ActionListener {

    JTextArea entrada, salida;
    JComboBox selector; //= new JComboBox();



    public Ventana() {


        //Elementos para utilizar
        //Creacion de cuadros de texto

         entrada = new JTextArea();
        //entrada.setSize(new Dimension(100, 100));
        entrada.setBounds(50, 50, 300, 350);

         salida = new JTextArea();
        //salida.setSize(new Dimension(100,100));
        salida.setBounds(500, 50, 300, 350);
        //Agregar cuadros de texto

        this.add(entrada);
        this.add(salida);



        JButton botooParaConvertir = new JButton("Convertir");
        botooParaConvertir.setBounds(375, 150, 100, 50);
        this.add(botooParaConvertir);

        //Agregar Listener
        botooParaConvertir.addActionListener(this);


        selector = new JComboBox();
        selector.addItem("XML");
        selector.addItem("JSON");
        selector.setBounds(375, 220, 100, 50);

        this.add(selector);


        //tamaño de ventana
        this.setSize(new Dimension(850, 500));
        //Evitar que se manipula la medida
        this.setResizable(false);

        //this.add(entrada, BorderLayout.EAST);
        //this.add(salida, BorderLayout.WEST);

        //Agregar Funcion de finalizar o Cerrar programa  con la X se finaliza la aaplicacion
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


    }

    public void actionPerformed(ActionEvent e){
        Ventana v = new Ventana();
        Convertidor c = new Convertidor();
        String textoEntrada = entrada.getText();
        String conversiontexto;

            if (textoEntrada.trim().length() == 0) {
                JOptionPane.showMessageDialog(
                        this, "No hay texto", "Texto vacio!!!", JOptionPane.WARNING_MESSAGE);
                System.out.println( "aqui entra");

            } else  {
             //System.out.println(textoEntrada);
                conversiontexto = c.convertirXml(textoEntrada,4);
                salida.setText("");
                salida.setText(conversiontexto);
            }
        }

        public static void main (String[] args){
            Ventana ventana = new Ventana();
            //Para que la ventana sea visible
            ventana.setVisible(true);


        }

    }

*/