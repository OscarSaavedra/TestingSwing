import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame implements ActionListener,ItemListener {
    private JComboBox menu1;
    private JButton botonExit,botonSuma,botonResta,botonConfirmarTexto;
    private JLabel label1;
    private JTextField textfield1,textfield2;
    private JTextArea areaTexto1,areaTexto2;
    private JScrollPane scroll1,scroll2;


    private Ventana(){
        setLayout(null);

        menu1=new JComboBox();
        menu1.setBounds(10 ,200,120,40);
        menu1.addItem("1");
        menu1.addItem("2");
        menu1.addItem("3");
        menu1.addItemListener(this);


        areaTexto1=new JTextArea();
        scroll1=new JScrollPane(areaTexto1);
        scroll1.setBounds(200,10,300,150);
        add(scroll1);

        areaTexto2=new JTextArea();
        scroll2=new JScrollPane(areaTexto2);
        scroll2.setBounds(200,200,300,150);
        add(scroll2);

        botonExit=new JButton("Salir");
        botonExit.setBounds(750,375,60,30);
        add(botonExit);
        botonExit.addActionListener(this);

        textfield1=new JTextField();
        textfield1.setBounds(10,10,120,30);
        add(textfield1);

        textfield2=new JTextField();
        textfield2.setBounds(10,50,120,30);
        add(textfield2);

        botonSuma=new JButton("+");
        botonSuma.setBounds(10,100,120,30);
        add(botonSuma);
        botonSuma.addActionListener(this);

        botonResta=new JButton("-");
        botonResta.setBounds(10,150,120,30);
        add(botonResta);
        botonResta.addActionListener(this);

        botonConfirmarTexto=new JButton("Verificar");
        botonConfirmarTexto.setBounds(10,400,120,30);
        add(botonConfirmarTexto);
        botonSuma.addActionListener(this);

        label1=new JLabel("versión 0");
        label1.setBounds(700,30,100,30);
        add(label1);
    }

    public void actionPerformed(ActionEvent clickBoton){
        if (clickBoton.getSource()==botonSuma){
            String numero1Texto=textfield1.getText();
            String numero2Texto=textfield2.getText();
                int numero1Int=Integer.parseInt(numero1Texto);
                int numero2Int=Integer.parseInt(numero2Texto);
                int suma=numero1Int+numero2Int;
                    String sumaTexto=String.valueOf(suma);
                    areaTexto1.setText (sumaTexto);
        }

        if (clickBoton.getSource()==botonResta){
            String numero1Texto=textfield1.getText();
            String numero2Texto=textfield2.getText();
            int numero1Int=Integer.parseInt(numero1Texto);
            int numero2Int=Integer.parseInt(numero2Texto);
            int resta=numero1Int-numero2Int;
            String sumaTexto=String.valueOf(resta);
            areaTexto1.setText (sumaTexto);
        }


        if (clickBoton.getSource()==botonExit){
            System.exit(0);
        }

        if (clickBoton.getSource()==botonConfirmarTexto){
            String texto1=areaTexto1.getText();
            String texto2=areaTexto2.getText();
            if (texto1.equals(texto2)) {
                setTitle("Coinciden");
                }
                else
                {
                setTitle("No coinciden");
                }
        }
    }

    public void itemStateChanged(ItemEvent abrirCombo) {
        if (abrirCombo.getSource()==menu1) {
            String seleccionado=(String)menu1.getSelectedItem();
            setTitle(seleccionado);
        }
    }

    public static void main(String[] args) {
        Ventana ventana1=new Ventana();
        ventana1.setTitle("Prueba");
        ventana1.setSize(900,500);
        ventana1.setVisible(true);
    }
}
