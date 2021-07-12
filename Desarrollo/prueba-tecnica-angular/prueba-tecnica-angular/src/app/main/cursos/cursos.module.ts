import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';
import { CrudCursoComponent } from './crud-curso/crud-curso.component';
import { ConsultaCursoComponent } from './consulta-curso/consulta-curso.component';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CrudCursoComponent,
    ConsultaCursoComponent,

  ],
  imports: [
    CommonModule,
    CursosRoutingModule,
    NgbDropdownModule,
    FormsModule, ReactiveFormsModule

  ]
})
export class CursosModule { }
