using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace SMTPServ
{
    class Program
    {
        static void Main(string[] args)
        {
            IPEndPoint endPoint = new IPEndPoint(IPAddress.Any, 25);
            TcpListener listener = new TcpListener(endPoint);
            listener.Start();

            while (true)
            {
                TcpClient client = listener.AcceptTcpClient();
                SMTPServer handler = new SMTPServer();
                handler.Init(client);
                Thread thread = new System.Threading.Thread(new ThreadStart(handler.Run));
                thread.Start();
            }
        }

        
    }
}
