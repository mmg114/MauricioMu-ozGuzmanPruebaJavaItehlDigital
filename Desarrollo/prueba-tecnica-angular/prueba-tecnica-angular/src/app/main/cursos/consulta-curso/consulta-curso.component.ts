import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { modalidad } from 'src/app/model/modalidad';
import { CursosService } from 'src/app/service/cursos.service';
import { GenericResponse } from 'src/app/utils/genericResponse';
import { global } from 'src/app/utils/global';


@Component({
  selector: 'app-consulta-curso',
  templateUrl: './consulta-curso.component.html',
  styleUrls: ['./consulta-curso.component.css']
})


export class ConsultaCursoComponent implements OnInit {


  form: FormGroup;
  subscription: Subscription;
  modalidad:modalidad[];


  constructor(private formBuilder: FormBuilder,
              private _CursoService:CursosService,
               ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      'modalidad': ['', ],
    });
    this.getModalidad();
  }

  getModalidad(){
    this.subscription = this._CursoService.consultarModalidades().subscribe((data: GenericResponse) => {
      if (data.codigo === global.HTTP_OK) {
          this.modalidad = data.lista;
      }
      if (data.codigo === global.HTTP_BAD_REQUEST) {
         // this.snackBar.open(data.mensaje, '×', { panelClass: 'error', verticalPosition: 'top', duration: 8000 });

      }
  }, error => {
     // this.snackBar.open(error, '×', { panelClass: 'error', verticalPosition: 'top', duration: 8000 });

  });

  }

}
