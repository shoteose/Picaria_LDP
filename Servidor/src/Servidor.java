import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Servidor {
    static Vector<ClientHandler> ar = new Vector<>();
    static int i = 0;

    public static void main(String[] args) throws IOException {
        try{
// Cria o servidor para receber coneções.
            ServerSocket ss = new ServerSocket(6666);
// Aguarda que receba uma coneção
            Socket s = ss.accept();
// Ao recebr uma coneção obtem o respetivo stream (DataStream)
            DataInputStream dis = new DataInputStream(s.getInputStream());
// Ler dados enviados pelo cliente
            String str = (String) dis.readUTF();
// Imprime os dados recebidos
            System.out.println("Mensagem = " + str);
// Fecha a coneção
            ss.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    private static class ClientHandler implements Runnable {
        private final String name;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket s;
        boolean isloggedin;

        private ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.name = name;
            this.isloggedin = true;
        }

        @Override
        public void run() {
            String recebido;

            while (true) {
                try {
                    recebido = dis.readUTF();
                    System.out.println(recebido);

                    if (recebido.endsWith("logout")) {
                        this.isloggedin = false;
                        this.s.close();
                        break; // while
                    }

                    StringTokenizer st = new StringTokenizer(recebido, "#");
                    if (st.countTokens() >= 2) {
                        String MsgToSend = st.nextToken();
                        String recipient = st.nextToken();

                        for (ClientHandler mc : Servidor.ar) {
                            if (mc.name.equals(recipient) && mc.isloggedin) {
                                mc.dos.writeUTF(this.name + " : " + MsgToSend);
                                break;
                            }
                        }
                    } else {
                        System.err.println("Mensagem recebida em formato inválido: " + recebido);
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao manusear o cliente: " + e.getMessage());
                    e.printStackTrace();
                    break; // Encerra o loop em caso de erro de IO
                }
            }
        }
    }
}
