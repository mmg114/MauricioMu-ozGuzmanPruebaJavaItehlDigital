import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DescuentosRoutingModule } from './descuentos-routing.module';
import { CrudDescuentosComponent } from './crud-descuentos/crud-descuentos.component';


@NgModule({
  declarations: [CrudDescuentosComponent],
  imports: [
    CommonModule,
    DescuentosRoutingModule,
  ]
})
export class DescuentosModule { }
