import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { modalidad } from '../model/modalidad';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  url:string;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(public httpClient:HttpClient) {
    this.url = environment.URL_SERVICIOS + 'curso';
  }


  public consultarCursosPorModalidad(modalidad:modalidad):Observable<any>{
    debugger
    return this.httpClient.post(this.url+'/buscarpormodelo',modalidad,this.httpOptions);
  }

}
