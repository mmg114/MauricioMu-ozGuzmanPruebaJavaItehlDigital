
export class GenericResponse {



  constructor(
    public codigo: string,
    public mensaje: string,
    public lista: Array<any>,
    public unitario: any  ) {}

}
