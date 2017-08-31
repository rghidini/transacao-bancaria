import 'rxjs/add/operator/map';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TransacaoModule } from './transacao/transacao.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ListagemComponent } from './listagem/listagem.component';
import { routing } from './app.routes';

@NgModule({
    imports: [BrowserModule, TransacaoModule, HttpModule, routing, FormsModule],
    declarations: [AppComponent, CadastroComponent, ListagemComponent],
    bootstrap: [AppComponent]
})
export class AppModule { }