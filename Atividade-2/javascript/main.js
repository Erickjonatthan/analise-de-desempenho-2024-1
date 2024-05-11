const fs = require('fs');
const path = require('path');
const ListaLigada = require('./ListaLigada'); // Supondo que você esteja usando a biblioteca 'linked-list'
const ExecutadorArquivo = require('./ExecutadorArquivo'); // Importando a classe ExecutadorArquivo

class Main {
    static main() {
       
        const path = require('path');
        const path1 = path.resolve(__dirname, 'arq.txt');
        const path2 = path.resolve(__dirname, 'arq1.txt');
        const path3 = path.resolve(__dirname, 'arq-novo.txt');

       

        const listaLigada = new ListaLigada();
        const executador = new ExecutadorArquivo();

        console.log("Resposta do arquivo (arq.txt):");
        executador.executa(path1, listaLigada);

        console.log("Resposta do arquivo (arq1.txt):");
        executador.executa(path2, listaLigada);

        console.log("Resposta do arquivo (arq-novo.txt):");
        executador.executa(path3, listaLigada);
    }
}

Main.main();