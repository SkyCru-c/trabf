import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MinhaTelinha extends JFrame {
    private List<Cliente> clientes = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> listaClientes = new JList<>(listModel);

    public MinhaTelinha() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        var meuTexto = new JLabel("Aula de Swing Prático");
        var botaoAdicionar = new JButton("Adicionar");

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarClienteFrame(MinhaTelinha.this);
            }
        });

        JScrollPane scrollPane = new JScrollPane(listaClientes);
        getContentPane().add("North", meuTexto);
        getContentPane().add("Center", scrollPane);
        getContentPane().add("South", botaoAdicionar);

        setVisible(true);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        listModel.addElement(cliente.getNome());
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MinhaTelinha();
            }
        });
    }

    // Classe interna para a janela de adicionar clientes
    class AdicionarClienteFrame extends JFrame {
        private JTextField nomeField;
        private JTextField enderecoField;
        private JTextField planoField;
        private JButton salvarButton;

        public AdicionarClienteFrame(MinhaTelinha mainFrame) {
            setTitle("Adicionar Cliente");
            setSize(300, 200);
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

            nomeField = new JTextField(15);
            enderecoField = new JTextField(15);
            planoField = new JTextField(15);
            salvarButton = new JButton("Salvar");

            add(new JLabel("Nome:"));
            add(nomeField);
            add(new JLabel("Endereço:"));
            add(enderecoField);
            add(new JLabel("Plano:"));
            add(planoField);
            add(salvarButton);

            salvarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = nomeField.getText();
                    String endereco = enderecoField.getText();
                    String plano = planoField.getText();
                    if (!nome.isEmpty() && !endereco.isEmpty() && !plano.isEmpty()) {
                        mainFrame.adicionarCliente(new Cliente(nome, endereco, plano));
                        dispose(); // Fecha a janela após salvar
                    }
                }
            });

            setVisible(true);
        }
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private String plano;

    public Cliente(String nome, String endereco, String plano) {
        this.nome = nome;
        this.endereco = endereco;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPlano() {
        return plano;
    }
}
