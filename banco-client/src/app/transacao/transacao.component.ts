import { Component, Input } from '@angular/core';
@Component({
    selector: 'transacao',
    templateUrl: './transacao.component.html'
})
export class TransacaoComponent {
    @Input() contaOrigem: number;
    @Input() contaDestino: number;
    @Input() valorTransferencia: number;
    @Input() taxa: number;
    @Input() dataAgendamento: number = Date.now();
    @Input() dataTransferencia: number;
}