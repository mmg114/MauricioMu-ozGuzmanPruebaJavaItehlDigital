import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaCursoComponent } from './consulta-curso/consulta-curso.component';
import { CrudCursoComponent } from './crud-curso/crud-curso.component';

const routes: Routes = [
  {
    path: '',
    component: CrudCursoComponent
  },
  {
    path: 'consulta',
    component: ConsultaCursoComponent
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursosRoutingModule { }
