
function salvarCliente() {
    const nome = document.getElementById('nome').value;
    const endereco = document.getElementById('endereco').value;
    const plano = document.getElementById('plano').value;

    if (nome && endereco && plano) {
        const cliente = { nome, endereco, plano };
        let clientes = JSON.parse(localStorage.getItem('clientes')) || [];
        clientes.push(cliente);
        localStorage.setItem('clientes', JSON.stringify(clientes));
        alert('Cliente salvo com sucesso!');
        window.location.href = 'index.html'; // Redireciona de volta para a página principal
    } else {
        alert('Por favor, preencha todos os campos.');
    }
}

function carregarClientes() {
    let clientes = JSON.parse(localStorage.getItem('clientes')) || [];
    const listaClientes = document.getElementById('listaClientes');
    listaClientes.innerHTML = ''; // Limpar lista antes de adicionar os elementos

    clientes.forEach(cliente => {
        const clienteDiv = document.createElement('div');
        clienteDiv.className = 'cliente';
        clienteDiv.innerHTML = `
            <p>Nome: ${cliente.nome}</p>
            <p>Endereço: ${cliente.endereco}</p>
            <p>Plano: ${cliente.plano}</p>
            <button onclick="editarCliente('${cliente.nome}')">Editar</button>
            <button onclick="excluirCliente('${cliente.nome}')">Excluir</button>
        `;
        listaClientes.appendChild(clienteDiv);
    });
}

function editarCliente(nome) {
    // Lógica para editar cliente
}

function excluirCliente(nome) {
    let clientes = JSON.parse(localStorage.getItem('clientes')) || [];
    clientes = clientes.filter(cliente => cliente.nome !== nome);
    localStorage.setItem('clientes', JSON.stringify(clientes));
    carregarClientes();
}
