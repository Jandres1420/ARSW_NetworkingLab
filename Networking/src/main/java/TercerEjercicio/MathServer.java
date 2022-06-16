package TercerEjercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        }catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String comprobar = "cos";
        while ((inputLine = in.readLine()) != null ) {
            System.out.println("Mensaje: " + inputLine);
            if(inputLine.equals("fun:sin")){
                comprobar = "sin";
                System.out.println("entro al if sin");

            }else if(inputLine.equals("fun:tan")){
                comprobar ="tan";
                System.out.println("entro al if tan");
            }else{
                double temp = 0;
                if(comprobar.equals("cos")){
                    temp = Double.parseDouble(inputLine);
                    System.out.println("El valor de coseno es: "+ cos(temp));
                }else if(comprobar.equals("tan")){

                }else if(comprobar.equals("sin")){

                }
            }
            outputLine = "Respuesta" + inputLine ;
            out.println(outputLine);
            System.out.println("Este es mio : " + outputLine);
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static double cos(double valor){
        return Math.cosh(valor);
    }

    public static double cambio(double valor){
        return 0;
    }
    public static double sin(double valor){
        return 0;
    }
    public static double tan(double valor){
        return 0;
    }

}


