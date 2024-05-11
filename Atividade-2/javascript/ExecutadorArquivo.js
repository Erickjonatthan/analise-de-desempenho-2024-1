const fs = require('fs');

class ExecutadorArquivo {
    executa(filePath, listaLigada) {
        const buffRead = fs.readFileSync(filePath, 'utf8').split('\n');

        const numerosIniciais = buffRead[0].split(' ');
        for (const numero of numerosIniciais) {
            listaLigada.insereFim(parseInt(numero));
        }

        for (let i = 2; i < buffRead.length; i++) {
            const linha = buffRead[i].trim();
            if (linha) {
                console.log(`Ação ${i - 1}:`);
                const acaoSplit = linha.split(' ');

                if (acaoSplit[0] === 'A') {
                    const valor = parseInt(acaoSplit[1]);
                    const posicao = acaoSplit[2] ? parseInt(acaoSplit[2]) - 1 : null;

                    if (posicao !== null) {
                        try {
                            listaLigada.insereElementoPosicao(valor, posicao);
                            console.log(`Valor ${valor} inserido na posição ${posicao + 1}.`);
                        } catch (e) {
                            console.log('Posição para inserir inválida. Continuando para a próxima ação.');
                        }
                    }
                    else {
                        console.log('Posição para inserir inválida. Continuando para a próxima ação.');
                        continue;
                    }
                } else if (acaoSplit[0] === 'R') {
                    const valor = parseInt(acaoSplit[1]);

                    //quando a ação remover é passado a posição
                    if (acaoSplit.length == 3) {
                        
                        const posicao = parseInt(acaoSplit[2]) - 1;
                        const valorPosicao = listaLigada.buscaIndice(posicao);
                        const valorExiste = listaLigada.buscaElemento(valor);

                        if (valorExiste && (valorPosicao == valor)) {
                            listaLigada.remove(valor);
                            console.log("Valor " + valor + " removido.");
                        } else {
                            console.log("O valor " + valor + " não existe na posição " + (posicao + 1) + ". Continuando para a próxima ação.");
                        }
                    }
                    //quando a ação remover é passado somente o valor
                    else if (listaLigada.buscaElemento(valor)) {
                        listaLigada.remove(valor);
                        console.log("Valor " + valor + " removido.");
                    } else {
                        console.log("O valor " + valor + " não existe na lista. Continuando para a próxima ação.");
                    }

                } else if (acaoSplit[0] === 'P') {
                    console.log(listaLigada.toString());
                    console.log('-------');
                }
            }
        }
    }
}

module.exports = ExecutadorArquivo;