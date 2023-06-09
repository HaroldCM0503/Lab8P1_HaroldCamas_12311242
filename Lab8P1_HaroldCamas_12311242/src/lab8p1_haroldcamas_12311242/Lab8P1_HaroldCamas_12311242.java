package lab8p1_haroldcamas_12311242;
import java.util.Scanner;

public class Lab8P1_HaroldCamas_12311242 {
    
    static Scanner leer = new Scanner(System.in);
    static Scanner cadenas = new Scanner(System.in);
    static boolean librero_creado = false;
    
    public static void main(String[] args) {
        boolean seguir = true;
        int opcion = 0;
        Libro[][] librero = null;
                
        while(seguir){
            opcion = Menu();
            
            switch(opcion){
                case 1:
                    librero = llenarLibrero();
                    System.out.println("El librero completo es: ");
                    Imprimir(librero);
                    librero_creado = true;
                    break;
                    
                case 2:
                    if (librero_creado == false){
                        System.out.println("Primero tiene que crear su librero!!!!");
                        break;
                    }
                    
                    System.out.println("Ingrese el titulo del libro: ");
                    String titulo = cadenas.nextLine();

                    System.out.println("Ingrese el autor del libro: ");
                    String autor = cadenas.nextLine();

                    System.out.println("Ingrese el año de publicacion del libro: ");
                    int año = leer.nextInt();
                    año = Validacion(año);
                    
                    librero = modificarLibrero(titulo,autor,año,librero);
                    System.out.println("El librero quedo asi: ");
                    Imprimir(librero);
                    break;
                    
                case 3:
                    seguir = false;
                    break;
                    
                default:
                    System.out.println("Introduzca una opcion valida.");
                    break;
            }
        }
    }
    
    public static int Menu(){
        int op = 0;
        System.out.println("");
        System.out.println("1.)Crear librero");
        System.out.println("2.)Modificar librero");
        System.out.println("3.)Salir");
        op = leer.nextInt();
        return op;
    }
    
    public static int Validacion(int numero){
        while(numero <= 0){
            System.out.println("Ingrese un numero valido!");
            numero = leer.nextInt();
        }
        return numero;
    }
    
    public static void Imprimir(Libro[][] librero){
        for(int i = 0; i < librero.length; i++){
            for(int j = 0; j< librero[i].length; j++){
                System.out.print("[" + librero[i][j].getTitulo() + "] ");
            }
            System.out.println("");
        }
    }
    
    public static Libro[][] llenarLibrero(){
        System.out.println("Ingrese la cantidad de filas: ");
        int filas = leer.nextInt();
        filas = Validacion(filas);

        System.out.println("Ingrese la cantidad de columnas: ");
        int columnas = leer.nextInt();
        columnas = Validacion(columnas);

        Libro[][] librero = new Libro[filas][columnas];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.println("Ingrese el titulo del libro: ");
                String titulo = cadenas.nextLine();

                System.out.println("Ingrese el autor del libro: ");
                String autor = cadenas.nextLine();

                System.out.println("Ingrese el año de publicacion del libro: ");
                int año = leer.nextInt();
                año = Validacion(año);

                Libro libro_ij = new Libro(titulo,autor,año);
                librero[i][j] = libro_ij;
                System.out.println("El libro fue agregado exitosamente \n");
            }
        }
        return librero;
    }
    
    public static Libro[][] modificarLibrero(String titulo, String autor, int año, Libro[][] librero){
        Libro nuevo = new Libro(titulo,autor,año);
        int[] coordenadas = Coordenadas(librero,nuevo);
        
        //Del metodo de coordenada, si el array regreso asi es porque nunca lo hallo y no hace nada.
        if(coordenadas[0] == -1 && coordenadas[1] == -1){
            System.out.println("El libro no esta en el librero");
        }
        
        else{
            System.out.println("El libro fue encontrado en la fila " + (coordenadas[0] + 1) + " columna " + (coordenadas[1] + 1));
            
            //Le pide al usuario los nuevos datos y los reemplaza con el metodo set a cada uno.
            System.out.println("Ingrese el titulo del nuevo libro: ");
            String tituloN = cadenas.nextLine();
            librero[coordenadas[0]][coordenadas[1]].setTitulo(tituloN);

            System.out.println("Ingrese el autor del nuevo libro: ");
            String autorN = cadenas.nextLine();
            librero[coordenadas[0]][coordenadas[1]].setAutor(autorN);

            System.out.println("Ingrese el año de publicacion del nuevo libro: ");
            int añoN = leer.nextInt();
            añoN = Validacion(añoN);
            librero[coordenadas[0]][coordenadas[1]].setAño(añoN);   
        }
        return librero;
    } 
    
    public static int[] Coordenadas(Libro[][] librero,Libro buscado){
        int[] coordenadas = new int[2];
        boolean encontrado = false;
        //Crea un array para guardas la posicion del libro buscado con formato: [fila,columna].
        
        for(int i = 0; i < librero.length; i++){
            for(int j = 0; j < librero[i].length;j++){
                Libro prueba = librero[i][j];
                if(prueba.getTitulo().equals(buscado.getTitulo())){
                    if(prueba.getAutor().equals(buscado.getAutor())){
                        if(prueba.getAño() == buscado.getAño()){
                            //Si el libro probado tiene el mismo titulo,autor y año que el buscado se guardan sus coordenadas en el array.
                            coordenadas[0] = i;
                            coordenadas[1] = j;
                            encontrado = true;
                        }
                    }
                } 
            }
        }
        
        //Si nunca se encontro al libro buscado y por ende el boolean nunca paso a true, las coordenadas las regresa como -1,-1.
        if(encontrado == false){
            coordenadas[0] = -1;
            coordenadas[1] = -1;
        }
        
        return coordenadas;
    }
}
