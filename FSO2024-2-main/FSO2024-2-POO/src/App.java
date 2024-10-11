import entidades.Cidade;
import entidades.Cliente;
import entidades.ClienteRecord;

public class App {
    public static void main(String[] args) throws Exception {
    
        var cliRecord = new ClienteRecord("Maria", "Rua lulul");
        System.out.println(cliRecord.nome());
       

        Cliente cliente = new Cliente("Zezinho");
        cliente.plano = "trimestral";
        var cliente.nome = new JLabel(cliente.getplano());
        var cliente.nome = new JLabel(cliente.getNome());
        var cliente.nome = new JLabel(cliente.getEndereco());
        var cliente.nome = new JLabel(cliente.getCidade());
        //cliente.nome = "zezinho";
        //cliente.setNome("zezinho");
        //Cliente cliente2 = new Cliente();
        //cliente2.setNome("Mariazinha");
        //NullPointException - ausencia de valor em uma variavel
    
        System.out.println(cliente.getNome());

        System.out.println("Hello, World!");

        System.out.println(cliente.toString());
        System.out.println(cliRecord);

        var joinville = new Cidade("Joinville");
        cliente.setCidade(joinville);
        System.out.println(cliente.getCidade().toString());

       


        /*cliente.getListaPokemon().add("univille");
        cliente.getListaPokemon().add("banana");
        cliente.getListaPokemon().add(1234);
        cliente.getListaPokemon().add(true);*/
        

    }
}
