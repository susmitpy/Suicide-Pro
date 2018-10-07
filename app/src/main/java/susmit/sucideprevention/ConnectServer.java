package susmit.sucideprevention;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectServer  {

    Socket socket;

    {
        try {
            socket = new Socket("192.168.0.1",1755);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    DataOutputStream DOS;

    {
        try {
            DOS = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    DOS.writeUTF("HELLO_WORLD");
    socket.close();
}
