# AKZeus2WikipediaData

AKZeus2WikipediaData es una librería para obtener información de un artista a través del API de Wikipedia, esta contiene:
- Breve texto sobre el artista
- URL del artículo de Wikipedia
- URL de la imagen del logo de Wikipedia

## Instalación
1. Clonar la librería en la carpeta libs.
2. Incluir la librería en settings.gradle
```
include ':zeus2wikipediadata'
project(':zeus2wikipediadata').projectDir = new File('libs/WikipediaData')
```
3. Incluir la librería en build.gradle
```
implementation project(":zeus2wikipediadata")
```
## Uso
Importamos el servicio del submodulo:
```
import zeus2wikipediadata.WikipediaService
```

Creamos una variable perteneciente al servicio de Wikipedia
```
val wikipediaService: WikipediaService
```

Creamos una instancia del servicio de Wikipedia
```
val wikipediaService: WikipediaService = wikipediaInfoService
```

Obtenemos el Articulo de la siguiente manera
```
val articulo =  wikipediaService.getArtistInfo(artistName)
```
El cual contendrá los siguientes atributos:

- `descripción`: Texto del articulo de Wikipedia recibido.
- `url`: URL del articulo recibido de Wikipedia.
- `sourceLogo`: URL del logo de Wikipedia.

En el caso de que exista algun error, como que no se haya encontrado algun articulo relacionado al artista buscado o no haya internet, 
la funcion retornara `null`.


 
