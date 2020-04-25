/**
 * @author Marco Ramirez 19588
 * @author Jose Ramos 
 * @version Final
 * @date 25/04/20
 * 
 * Hoja de trabajo 9
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de datos 2020
 * Seccion 10
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HT9 {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException{
        int op = 0; 
        //Declaracion del factory
        Factory fac = new Factory();
        
        SplayTree<String,String> SPTree = null;
        RedBlackBST<String,String> RBTree = null;
        
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String entry="";
        
        //Realizara este ciclo hasta que el usuario ingrese el numero 1 o 2
        do {
        System.out.println("¿Cual deseas usar? (Solo numeros) \n");
        System.out.println("1. SplayTree");
        System.out.println("2. RedBlackTree");
         entry = sc1.nextLine();
        
         
        }while(Integer.parseInt(entry)!=1 && Integer.parseInt(entry)!=2 );
        
        Object Tree;
        //Dependiendo de la opcion ingresada del usuario se usara la adecuada implementacion
            switch(entry){            
            case "1":                         
                SPTree = (SplayTree)fac.getImp("SplayTree"); 
                break;
            case "2":                         
                RBTree = (RedBlackBST)fac.getImp("RedBlackTree");                    
                break;                     
        }
        	
      
   
     
            //Lee el archivo Spanish.txt, donde contiene el diccionario
            BufferedReader br = new BufferedReader(new FileReader("Spanish.txt"));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = "";  
                String line2 = "";                                                
                String english = "";
                String spanish = "";                
               //Traducira el mensaje encontrado en el archivo texto.txt
                
                long startTimeSearch=System.nanoTime(); //Empieza a contar el tiempo de ejecucion del lector de datos
                while ((line=br.readLine())!=null) { //Se obtiene el primer significado en espanol unicamente.
                    sb.append(line);
                    sb.append(System.lineSeparator()); 
                    line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                       //por substring      
                    for(int i=1;i<line.length();i++){
                        String iter = line.substring((i-1), i); //iterador que toma el valor de cada letra de la linea
                        if(iter.equals("\t")){
                            english = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de " "  
                            line2 = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de " "                            
                            for(int e=1;e<line2.length();e++){
                                String iter2 = line2.substring((e-1), e);
                                if(iter2.equals(";")||iter2.equals(",")){
                                    spanish = line2.substring(0, e-1).toUpperCase(); //se obtiene la subcadena antes de , o ;  
                                    break;
                                }else{
                                    spanish = line2; //sino se encuentra una , o un ; 
                                }                                
                            }
                            System.out.println(english +", "+ spanish); 
                            if(entry.equals("1")){
                                SPTree.put(english, spanish);
                            }else{
                                RBTree.put(english,spanish);
                            }  
                        }                        
                    }
                  
                                      
                }
                long endTimeSearch = System.nanoTime()-startTimeSearch; //Termina el conteo de tiempo y lo muestra
                System.out.println("\nTiempo de procesamiento de datos "+endTimeSearch+"\n");
                System.out.println("¿Que desea hacer?\n");
                System.out.println("1. Traducir el archivo guardado como texto.txt");
                System.out.println("2. Salir");
                op = sc1.nextInt();               
                while(op != 2){
                	//Profiller de la traduccion
                	long startTime = System.nanoTime();
                    if(op == 1){
                        String translator = "";
                        String traductor = "";
                        //Se lee el archivo deseado a traducir guardado como texto.txt
                        File spanishTxt = new File ("texto.txt");

                        FileReader fr = new FileReader (spanishTxt);
                        BufferedReader br1 = new BufferedReader(fr);
                        String linea = "";
                        Scanner scanner = new Scanner(fr);
                        String word = "";
        
                        while (scanner.hasNextLine()) {
                            linea += scanner.nextLine();
                            word = linea.replaceAll("\n", " ");
                        }
                        fr.close();
                        br1.close();
                        //Separa las palabras encontradas y su traduccion
                        String data[] = word.split(" ");
                        for(int i = 0; i < data.length;i++){
                            word = data[i];
                            word = word.toUpperCase();
                            String prueba = "";
                            if(entry.equals("1")){
                                prueba = SPTree.get(word);
                            }else{
                                prueba = RBTree.get(word);
                            }                             
                            if(prueba == null){
                                prueba = "*" + word + "*";
                            }
                            translator = translator + " " + prueba + " ";
                        }
                        System.out.println("Traduccion: ");
                        System.out.println("\n"+translator+"\n");
                        long endTime =System.nanoTime()-startTime;//Final del profiller de traduccion y muestra el tiempo en el que se realizo
                        System.out.println("Tiempo de traduccion: "+ endTime+" nanosegundos\n");
                        
                        
                    }else{
                        System.out.println("No ha ingresado una opcion valida");
                    }    
                    System.out.println("¿Que desea hacer?\n");
                    System.out.println("1. Traducir el archivo guardado como texto.txt");
                    System.out.println("2. Salir");
                op = sc1.nextInt();
                }
                
            }
            finally{
                br.close();
                System.out.println("¡Feliz dia!");
            }  
        
        
    }
    
}
