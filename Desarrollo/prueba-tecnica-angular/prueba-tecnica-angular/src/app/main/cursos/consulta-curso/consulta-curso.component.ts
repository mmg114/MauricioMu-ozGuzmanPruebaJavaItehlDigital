import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { curso } from 'src/app/model/curso';
import { modalidad } from 'src/app/model/modalidad';
import { CursosService } from 'src/app/service/cursos.service';
import { ModalidadService } from 'src/app/service/modalidad.service';
import { GenericResponse } from 'src/app/utils/genericResponse';
import { global } from 'src/app/utils/global';


@Component({
  selector: 'app-consulta-curso',
  templateUrl: './consulta-curso.component.html',
  styleUrls: ['./consulta-curso.component.css']
})


export class ConsultaCursoComponent implements OnInit {

  subscription: Subscription;
  modalidad:modalidad[];
  modalidadSelected:modalidad;
  modalidadSelectedGuardar:modalidad;
  dataTable:curso[];

  constructor(
              private _CursoService:CursosService,
              private _ModalidadService:ModalidadService,
              private modalService: NgbModal) { }

  ngOnInit(): void {

   this.getModalidad();
  }

  getModalidad(){

    this.subscription = this._ModalidadService.consultarModalidades().subscribe((data: GenericResponse) => {

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

   getData(moda:modalidad){
debugger
    this.subscription = this._CursoService.consultarCursosPorModalidad(moda).subscribe((data: GenericResponse) => {

      if (data.codigo === global.HTTP_OK) {
        debugger
          this.dataTable = data.lista;
      }
      if (data.codigo === global.HTTP_BAD_REQUEST) {
         // this.snackBar.open(data.mensaje, '×', { panelClass: 'error', verticalPosition: 'top', duration: 8000 });

      }
  }, error => {
     // this.snackBar.open(error, '×', { panelClass: 'error', verticalPosition: 'top', duration: 8000 });

  });

  }


  triggerModal() {
    this.modalService.open( {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {

    }, (res) => {

    });
  }



  guardar(){



  }



}
