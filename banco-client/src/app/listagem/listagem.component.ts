import { Component } from '@angular/core';
import { Http } from '@angular/http';
@Component({
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent {
    transacoes: Object[] = [];

    constructor(http: Http) {

        http.get('http://localhost:3004/transacoes')
            .map(res => res.json())
            .subscribe(
            transacoes => this.transacoes = transacoes,
            erro => console.log(erro)
            );
    }
}