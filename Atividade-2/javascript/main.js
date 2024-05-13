const fs = require('fs');
const path = require('path');
const ListaLigada = require('./ListaLigada'); // Supondo que você esteja usando a biblioteca 'linked-list'
const ExecutadorArquivo = require('./ExecutadorArquivo'); // Importando a classe ExecutadorArquivo

class Main {
    static main() {
       
        const path_req = require('path');

        const path = path_req.resolve(__dirname, 'arq-novo.txt');

        const listaLigada = new ListaLigada();
        const executador = new ExecutadorArquivo();

        console.log("Resposta do arquivo (arq-novo.txt):");
        executador.executa(path, listaLigada);
    }
}

Main.main();