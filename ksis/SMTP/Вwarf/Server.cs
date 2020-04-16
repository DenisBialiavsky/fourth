using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Dwarf
{
    class SMTPServer
    {
       
        TcpClient client;
        public event Action<string> Recived = (w) => { };
        public event Action<string> Detached = (s) => { };
        public string log = "";
        public SMTPServer(TcpClient client)
        {
            this.client = client;
        }

        public void Run()
        {
            Write("220 localhost -- Fake proxy server");
            string strMessage = String.Empty;
            while (true)
            {
                try
                {
                    strMessage = Read();
                }
                catch 
                {
                    Detached(log);
                    break;
                }

                if (strMessage.Length > 0)
                {  
                    if (strMessage.StartsWith("QUIT"))
                    {
                        client.Close();
                        Detached(log);
                        break;
                    }
                    if (strMessage.StartsWith("EHLO"))
                    {
                        Write("250 OK");
                    }
                    if (strMessage.StartsWith("RCPT TO"))
                    {
                        Write("250 OK");
                    }
                    if (strMessage.StartsWith("MAIL FROM"))
                    {
                        Write("250 OK");
                    }
                    if (strMessage.StartsWith("DATA"))
                    {
                        Write("354 Start mail input; end with");
                        strMessage = Read();
                        Write("250 OK");
                    }
                }
            }
        }

        private void Write(String strMessage)
        {
            NetworkStream clientStream = client.GetStream();
            ASCIIEncoding encoder = new ASCIIEncoding();
            byte[] buffer = encoder.GetBytes(strMessage + "\r\n");

            clientStream.Write(buffer, 0, buffer.Length);
            clientStream.Flush();
            log += "\nS : " + strMessage;
            Recived("\nS : " + strMessage);
           
        }

        private String Read()
        {
            byte[] messageBytes = new byte[8192];
            int bytesRead = 0;
            NetworkStream clientStream = client.GetStream();
            ASCIIEncoding encoder = new ASCIIEncoding();
            bytesRead = clientStream.Read(messageBytes, 0, 8192);
            string strMessage = encoder.GetString(messageBytes, 0, bytesRead);
            Recived("\nC : " + strMessage);
            log += "\nC : " + strMessage;
            return strMessage;
        }
    }
}
