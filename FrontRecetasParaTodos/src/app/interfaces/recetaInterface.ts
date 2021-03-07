export interface Receta
{
    id?: number;
    nombre: string;
    ingredientes: string[];
    preparacion: string;
    tiempoPreparacion: string;
    raciones: number;
    microondas: boolean;
    categoria: string;
    nombreUsuario: string;
}