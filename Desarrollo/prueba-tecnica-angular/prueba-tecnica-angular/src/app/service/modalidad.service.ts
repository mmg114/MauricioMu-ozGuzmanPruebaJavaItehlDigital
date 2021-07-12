import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ModalidadService {


  url:string;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(public httpClient:HttpClient) {
    this.url = environment.URL_SERVICIOS + 'modalidad';
  }

  public consultarModalidades():Observable<any>{
    return this.httpClient.get(this.url,this.httpOptions);
  }

}
