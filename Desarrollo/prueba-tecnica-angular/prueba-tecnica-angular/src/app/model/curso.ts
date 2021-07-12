import { modalidad } from "./modalidad";


  export interface curso {
      _id: string;
      nombre: string;
      costo: number;
      descripcion: string;
      horas: number;
      dirigido: string;
      modalidad: modalidad[];
      _class: string;
  }

