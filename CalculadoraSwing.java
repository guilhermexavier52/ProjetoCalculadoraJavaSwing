package calculadoraSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSwing extends JFrame implements ActionListener {

	private static final long serialVersionUID = 959431443786654859L;
	private JTextField display;
    private JButton[] botoesNumeros;
    private JButton[] botoesOperadores;
    private JButton botaoLimpar;
    private JButton botaoResultado;
    private double primeiroNumero;
    private double segundoNumero;
    private String operador;
    
public CalculadoraSwing() {

            setTitle("CALCULADORA");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            setVisible(true);   
           
                  

            // Painel do display

            display = new JTextField();
            display.setEditable(false);
            add(display, BorderLayout.NORTH);



            // Painel dos botões

            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(4, 4));
            painelBotoes.setBackground(Color.RED);
           


            // Criar e adicionar botões numéricos

            botoesNumeros = new JButton[10];
            for (int i = 0; i < 10; i++) {

            botoesNumeros[i] = new JButton(Integer.toString(i));
            botoesNumeros[i].addActionListener(this);
            painelBotoes.add(botoesNumeros[i]);

            }


            // Criar e adicionar botões de operadores

            botoesOperadores = new JButton[4];
            botoesOperadores[0] = new JButton("+");
            botoesOperadores[1] = new JButton("-");
            botoesOperadores[2] = new JButton("*");
            botoesOperadores[3] = new JButton("/");

            for (JButton botao : botoesOperadores) {

                botao.addActionListener(this);
                painelBotoes.add(botao);

            }



            // Criar botão de resultado

            botaoResultado = new JButton("=");
            botaoResultado.addActionListener(this);
            painelBotoes.add(botaoResultado);



            // Criar botão de limpar

            botaoLimpar = new JButton("C");
            botaoLimpar.addActionListener(this);
            painelBotoes.add(botaoLimpar);

            add(painelBotoes, BorderLayout.CENTER);
            setVisible(true);
            
    

        }


		@Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
                 primeiroNumero = Double.parseDouble(display.getText());
                operador = comando;
                display.setText("");
            } else if (comando.equals("=")) {
                segundoNumero = Double.parseDouble(display.getText()); // retirei double
                double resultado = 0;
                switch (operador) {
                    case "+":
                        resultado = primeiroNumero + segundoNumero;
                      
                        break;
                    case "-":
                        resultado = primeiroNumero - segundoNumero;
                        break;
                    case "*":
                        resultado = primeiroNumero * segundoNumero;
                        break;
                    case "/":
                        if (segundoNumero != 0) {
                            resultado = primeiroNumero / segundoNumero;
                        } else {
                            JOptionPane.showMessageDialog(this, "Não é possível dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
                display.setText(Double.toString(resultado));
            } else if (comando.equals("C")) {
                display.setText("");
            } else {
                display.setText(display.getText() + comando);
            }
        }


        public static void main(String[] args) {

            SwingUtilities.invokeLater(new Runnable() {

                @Override

                public void run() {

                    new CalculadoraSwing();

                }
            });
        }
    }
    
    
 