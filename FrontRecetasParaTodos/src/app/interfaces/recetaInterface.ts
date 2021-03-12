export interface Receta
{
    id?: number;
    nombre: string;
    ingredientes: string[];
    preparacion: string;
    horas: number;
    minutos: number;
    raciones: number;
    microondas?: boolean;
    categoria?: string;
    nombreUsuario: string;
}