import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  { path: 'cursos',
    loadChildren: () => import('./main/cursos/cursos.module').then(mod => mod.CursosModule)},
  { path: 'descuentos',
  loadChildren: () => import('./main/descuentos/descuentos.module').then(mod => mod.DescuentosModule)},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
