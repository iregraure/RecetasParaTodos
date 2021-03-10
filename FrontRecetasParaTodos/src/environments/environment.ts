// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  loginUrl: "http://localhost:8080/user/login",
  signUpUrl: "http://localhost:8080/user/sign-up",
  nacionalidadUrl: "http://localhost:8080/nacionalidad",
  apiUrl: "http://localhost:8080",
  categoriasUrl: "http://localhost:8080/categoria",
  recetasCategoriaUrl: "http://localhost:8080/receta/categoria/",
  recetaUrl: "http://localhost:8080/receta/",
  usuarioUrl: "http://localhost:8080/usuario/",
  usuarioAutenticadoUrl: "http://localhost:8080/user/autenticado/",
  recetaRandomUrl: "http://localhost:8080/receta/random"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
