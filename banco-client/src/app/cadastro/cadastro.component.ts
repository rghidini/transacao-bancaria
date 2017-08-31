import { Component } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { TransacaoComponent } from '../transacao/transacao.component';

@Component({
    selector: 'cadastro',
    templateUrl: './cadastro.component.html'
})
export class CadastroComponent {
    transacao: TransacaoComponent = new TransacaoComponent();
    http: Http;

    constructor(http: Http) {
        this.http = http;
    }

    calcularTaxa() {
        event.preventDefault();
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        console.log(this.transacao.dataTransferencia);
        this.http.post('http://localhost:3004/taxa', JSON.stringify(this.transacao), { headers: headers })
            .subscribe((resp) => {
                if (resp.json().taxa == 0) alert('Não existem taxas a serem aplicadas'), this.transacao.taxa = 0; else this.transacao.taxa = resp.json().taxa;
                console.log(resp.json());
            }, erro => console.log(erro));
        console.log(this.transacao);
    }


    cadastrar() {
        event.preventDefault();
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        this.http.post('http://localhost:3004/cadastro-transacoes', JSON.stringify(this.transacao), { headers: headers })
            .subscribe(() => {
                this.transacao = new TransacaoComponent();
                console.log('Transação salva com sucesso');
            }, erro => console.log(erro));
        console.log(this.transacao);
    }
}