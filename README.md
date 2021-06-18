# AKZeus2WikipediaData

Para utilizar esta librería, primero hay que saber como está conformada la clase `Card`. 

## Card
La clase card contiene los siguientes atributos:

- `descripción`: Texto del articulo de Wikipedia recibido.
- `url`: URL del articulo recibido de Wikipedia.
- `sourceLogo`: URL del logo de Wikipedia.

## ¿Cómo usar la librería?
Para utilizar la librería, solamente hace falta usar la función `getArtistInfo` de la clase WikipediaService. Para usar la función, debemos pasarle como parámetro el nombre del artista del que se quiere obtener la información. 

La función retorna una `card` en caso de que exista el articulo de Wikipedia del artista. Retorna `null` en el caso de que no exista o haya algún otro error, como que no se esté conectado a internet. 
