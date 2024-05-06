import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ServidorGlobal {

    static Vector<ClientHandler> ar = new Vector<>();
    static int i = 0;

    @FXML
    protected void voltar(ActionEvent event) throws IOException {

    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        try {
            System.out.println("Servidor aceita conexões.");
            ServerSocket ss = new ServerSocket(1234);

            Socket s;
            while(true){
                s = ss.accept();
                System.out.println("Novo client recebido : " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                ClientHandler mtch = new ClientHandler(s, "client " + i, dis, dos);
                Thread t = new Thread(mtch);

                System.out.println("Adiciona cliente "+ i + " à lista ativa.");
                ar.add(mtch);
                t.start();

                i++;
            }
        }catch(Exception e) {System.out.println(e.getMessage());}
    }
    private static class ClientHandler implements Runnable {
        private String name;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket s;
        boolean isloggedin;

        private ClientHandler(Socket s, String string,
                              DataInputStream dis, DataOutputStream dos) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.name = string;
            this.isloggedin = true;
        }

        @Override
        public void run() {
            String recebido;

            while(true){
                try {
                    recebido = dis.readUTF();
                    System.out.println(recebido);

                    if(recebido.endsWith("logout")){
                        this.isloggedin = false;
                        this.s.close();
                        break; // while
                    }
                    /**/
                    /*StringTokenizer st = new StringTokenizer(recebido, "#");
                    String MsgToSend = st.nextToken();
                    String recipient = st.nextToken();
                    for(ClientHandler mc: ServidorGlobal.ar){
                        if(mc.name.equals(recipient) && mc.isloggedin) {
                            mc.dos.writeUTF(name + " : " + MsgToSend);
                            break;
                        }
                    }*/
                    for(ClientHandler mc: ServidorGlobal.ar){

                        if(recebido == "") {

                        }
                        else {
                            mc.dos.writeUTF(this.name + ": " + recebido);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
