# AKZeus2WikipediaData

Para utilizar esta librería, primero hay que saber como está conformada la clase `Card`. 

## Card
La clase card contiene los siguientes atributos:

- `descripción`: Texto del articulo de Wikipedia recibido.
- `url`: URL del articulo recibido de Wikipedia.
- `sourceLogo`: URL del logo de Wikipedia.

## ¿Cómo usar la librería?
Para utilizar la librería, debemos usar la función `getArtistInfo` de la clase WikipediaService. 
Para usar la función, debemos pasarle como parámetro el nombre del artista del que se quiere obtener la información y la funcion
nos retornara una `card` de wikipedia. Dicha `card` contendra la informacion contenida en un articulo de Wikipedia del artista. 

## Código
Primero importamos el servicio del submodulo:
`import zeus2wikipediadata.WikipediaService`

Creamos una variable que llame al Servicio de Wikipedia
`private val wikipediaService: WikipediaService`

Luego la utilizamos para llamar al método "getArtistInfo"
`wikipediaService.getArtistInfo(artistName)`

En el caso de que exista algun error, como que no se haya encontrado algun articulo relacionado al artista buscado o no haya internet, 
la funcion retornara `null`.
