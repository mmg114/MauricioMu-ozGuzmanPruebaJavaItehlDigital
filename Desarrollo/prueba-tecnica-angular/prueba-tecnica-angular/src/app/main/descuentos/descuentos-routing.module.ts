import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrudDescuentosComponent } from './crud-descuentos/crud-descuentos.component';

const routes: Routes = [
  {
    path: '',
    component: CrudDescuentosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DescuentosRoutingModule { }
